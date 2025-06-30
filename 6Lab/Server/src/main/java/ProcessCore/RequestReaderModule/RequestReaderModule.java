package Server;

import NetworkPackage.NetworkRequestaGenericPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class RequestReaderModule {

  protected NetworkRequestaGenericPackage packData;

  public RequestReaderModule(Socket sock) {
    try {

      ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
      NetworkRequestaGenericPackage packData = (NetworkRequestaGenericPackage) ois.readObject();

      this.packData = packData;

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public NetworkRequestaGenericPackage getPackData() {
    return packData;
  }
}
