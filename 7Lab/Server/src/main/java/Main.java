package Server;

import Collection.CollectionManager;
import Collection.InitialiseArray.InitialiseArray;
import NetworkPackage.NetworkRequestGenericPackage;
import NetworkPackage.NetworkResponceGenericPackage;
import ProcessCore.ProcessCommandModule.ProcessCommand;
import ProcessCore.ConnectionRecieverModule.ConnectionReciever;
import ProcessCore.DispatchClientModule.DispatchClient;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private final ExecutorService readerPool = Executors.newFixedThreadPool(3);
    private final ExecutorService processorPool = Executors.newFixedThreadPool(5);
    private final ForkJoinPool sendPool = new ForkJoinPool();

    private final ConnectionReciever connectionModule;
    private final CollectionManager collectionManager;

    public Main(int port) throws IOException {
        this.connectionModule  = new ConnectionReciever(port, logger);
        this.collectionManager = new CollectionManager(new InitialiseArray().getArray());
    }

    public void start() {
        new Thread(this::startConsoleThread, "Console-Thread").start();

        while (!Thread.currentThread().isInterrupted()) {
          RequestTask task;
          try {
            task = receiveRequest();
          } catch (Exception e) {
            logger.error("Ошибка при получении запроса", e);
            continue;
          }
          CompletableFuture
          .supplyAsync(() -> processRequest(task), processorPool)
          .thenAcceptAsync(response -> sendResponse(response), sendPool)
          .exceptionally(e -> {
            logger.error("Ошибка при обработке запроса", e);
            return null;
          });
        }
        
    }

    public RequestTask receiveRequest() {
        try {
          NetworkRequestGenericPackage pack = connectionModule.start();
          Socket clientSocket = connectionModule.getTemporarySocket();
          
          logger.info("Запрос в очередь (команда): {}", pack.getCommandName());
          return new RequestTask(pack, clientSocket);

        } catch (IOException e) {
          logger.error("Ошибка при запросе в очереди", e);
          throw new RuntimeException("Приём прерван"); 
        }
    }

    public ResponseTask processRequest(RequestTask task) {
      ProcessCommand processor = new ProcessCommand(collectionManager, task.pack);
      NetworkResponceGenericPackage responsePack = processor.getNetworkResponcePack();
      logger.info("Процесс: {}", task.pack.getCommandName());

      final Socket socketToUse = task.clientSocket;
      final String commandName = task.pack.getCommandName();

      return new ResponseTask(responsePack, socketToUse, commandName);
    }

    public void sendResponse(ResponseTask response) {
      DispatchClient sender = new DispatchClient(response.pack, response.clientSocket);
      try {
        sender.sendResponce();
        logger.info("Отправлеие ответа для: {}", response.commandName + "\n");
      } catch (IOException e) {
        logger.error("Ошибка при отправке ответа", e + "\n");
      }
    }

    private void startConsoleThread() {
      Scanner scan = new Scanner(System.in);
      logger.info("> Серверная консоль запущена...");
      System.out.println("Для остановки сервера введите: stopServer");

      while (true) {
        String line = scan.nextLine().trim();
        if ("stopServer".equalsIgnoreCase(line)) {
          logger.info("> Останавливаем сервер...");
          readerPool.shutdownNow();
          processorPool.shutdownNow();
          sendPool.shutdown();
          System.exit(0);
          break;
        } else {
          System.out.println("Неизвестная команда: " + line);
        }
      }
    }

    public static void main(String[] args) throws IOException {
      int port = 6066;
      Main server = new Main(port);
      server.start();
    }

    private static class RequestTask {

      final NetworkRequestGenericPackage pack;
      final Socket clientSocket;
      
      RequestTask(NetworkRequestGenericPackage p, Socket s) {
        this.pack = p;
        this.clientSocket = s;
      }
    }

    private static class ResponseTask {

      final NetworkResponceGenericPackage pack;
      final Socket clientSocket;
      final String commandName;
      
      ResponseTask(NetworkResponceGenericPackage p, Socket s, String commandName) {
        this.pack = p;
        this.clientSocket = s;
        this.commandName = commandName;
      }
    }
}
