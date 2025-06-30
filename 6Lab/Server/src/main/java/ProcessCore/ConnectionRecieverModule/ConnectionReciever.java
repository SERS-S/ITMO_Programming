package Server;

import NetworkPackage.NetworkRequestaGenericPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;

public class ConnectionReciever {
  private ServerSocket serv;
  private final int port;
  private Socket temporarySocket;

  private Logger logger;

  public ConnectionReciever(int port, Logger logger) throws IOException {
    this.logger = logger;
    this.port = port;
    serv = new ServerSocket(port);
    logger.info("Ожидание подключений на порту " + port + "...\n");
  }

  protected NetworkRequestaGenericPackage start() throws IOException {
    Socket sock = serv.accept();
    logger.info("Подключение установлено: " + sock.getInetAddress());

    RequestReaderModule requestReaderModule = new RequestReaderModule(sock);

    this.temporarySocket = sock;
    return requestReaderModule.getPackData();
  }

  public Socket getTemporarySocket() {
    return temporarySocket;
  }

  public void closeTemporarySocket() throws IOException {
    temporarySocket.close();
  }

}
