package ProcessCore.ConnectionRecieverModule;

import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.RequestReaderModule.RequestReaderModule;

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
    logger.info("Ожидание подключений на порту " + this.port + "...\n");
  }

  public NetworkRequestGenericPackage start() throws IOException {
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
