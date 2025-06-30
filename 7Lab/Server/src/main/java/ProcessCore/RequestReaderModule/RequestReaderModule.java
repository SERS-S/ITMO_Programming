package ProcessCore.RequestReaderModule;

import NetworkPackage.NetworkRequestGenericPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class RequestReaderModule {

  protected NetworkRequestGenericPackage packData;

  public RequestReaderModule(Socket sock) {
    try {

      ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
      NetworkRequestGenericPackage packData = (NetworkRequestGenericPackage) ois.readObject();

      this.packData = packData;

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public NetworkRequestGenericPackage getPackData() {
    return packData;
  }
}
