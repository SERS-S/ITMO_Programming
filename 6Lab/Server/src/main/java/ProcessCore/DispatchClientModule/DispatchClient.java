package Server;

import NetworkPackage.NetworkResponceGenericPackage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DispatchClient {

  NetworkResponceGenericPackage networkResponcePack;
  Socket temporaSocket;

  public DispatchClient(NetworkResponceGenericPackage networkResponcePack, Socket temporarySocket) {
    this.networkResponcePack = networkResponcePack;
    this.temporaSocket = temporarySocket;
  }

  public void sendResponce() throws IOException {

    if (networkResponcePack.getCorrectCommand()) {
      OutputStream os;

      os = temporaSocket.getOutputStream();
      try (ObjectOutputStream oos = new ObjectOutputStream(os)) {

        oos.writeObject(networkResponcePack);

      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Ошибка при отправке данных на клиент!");
      }
    }
  }
}
