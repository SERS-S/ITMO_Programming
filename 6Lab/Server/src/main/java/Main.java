package Server;

import Collection.CollectionManager;
import Collection.InitialiseArray.InitialiseArray;
import Collection.SaveCollection.SaveCollectionToCSV;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.ProcessCommand;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void startConsoleThread(CollectionManager collectionManager) {
    // stopServer - завершение работы сервера
    // save - сохранение коллекции в файл

    Scanner scan = new Scanner(System.in);
    logger.info("> Серверная консоль запущена...");
    System.out.println("Для ввода доступны следующие команды: " + "{ stopServer }" + ", " + "{ save }");

    while (true) {
      String line = scan.nextLine();
        boolean flag = true;
        if (line.equals("stopServer")) {
          SaveCollectionToCSV.saveCollectionToCSV(collectionManager);
          flag = false;
          System.exit(0);
          break;
        } else if (line.equals("save")) {
          SaveCollectionToCSV.saveCollectionToCSV(collectionManager);
          flag = false;
        } else if (flag) {
          System.out.println("Некорректно введенные данные!");
        }
    }
    logger.info("> Сервер завершает работу...");
  }

  public static void main(String[] args) {
    
    try {

      ConnectionReciever connectionModule = new ConnectionReciever(6066, logger);      
      CollectionManager collectionManager = new CollectionManager((new InitialiseArray()).getArray());
      Thread consolThread = new Thread(() -> {startConsoleThread(collectionManager);});
      consolThread.start();

      while (true) {
        try {

          NetworkRequestaGenericPackage packOne = connectionModule.start();
          logger.info("Получен новый запрос по команде: " + packOne.getCommandName());
          ProcessCommand prossComm = new ProcessCommand(collectionManager, packOne);

          DispatchClient sendData = new DispatchClient(prossComm.getNetworkResponcePack(), connectionModule.getTemporarySocket());
          sendData.sendResponce();
          logger.info("Ответ на запрос отправлен");
          connectionModule.closeTemporarySocket();
          logger.info("Подключение обработано и завершено\n");

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      System.out.println("Ошибка при работе сервера!");
      e.printStackTrace();
    }
  }

}