package Client;

import ColorText.ColorResponce;
import ColorText.ColorText;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.Command;
import NetworkPackage.NetworkRequestaGenericPackage;
import NetworkPackage.NetworkResponceGenericPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

  static boolean serverRequestFlag = false;

  public static void sendDataToServer(NetworkRequestaGenericPackage packData) {
    System.out.println(
        ColorText.ColorPURPLE("  > ") + ColorText.ColorGREEN("Отправение данных на сервер..."));

    try {

      Socket sock;
      OutputStream os;
      InputStream is;
      InetAddress host;
      final int port = 6066;

      host = InetAddress.getByName("localhost");
      sock = new Socket(host, port);
      os = sock.getOutputStream();

      ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
      oos.writeObject(packData);
      oos.flush();

      if (packData.getCorrectedInputData()) {
        ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
        NetworkResponceGenericPackage responceDataPack =
            (NetworkResponceGenericPackage) ois.readObject();

        ColorResponce.ColorOutputText(responceDataPack.getResponceStrings());
      }

      oos.close();
      sock.close();

    } catch (Exception e) {
      System.out.println(ColorText.ColorRED("Ошибка при отправке данных на сервер!"));
    }

    // try {
    //   Thread.sleep(3000);
    // } catch (InterruptedException e) {
    //   Thread.currentThread().interrupt();
    // }
    System.out.println(
        "~ " + ColorText.ColorBLUE("Итерация по введенным данным в консоли прошла!"));
  }

  public static void main(String[] args) throws IOException {

    CommandManager commandManager = new CommandManager();

    Scanner scan = new Scanner(System.in);
    System.out.println(ColorText.ColorCYAN("> Консоль запущена..."));
    outerloop:
    while (true) {
      String line = scan.nextLine();
      if (!serverRequestFlag) {
        boolean flag = true;
        for (Command cmd : commandManager.getCommandsList()) {
          if (line.contains(cmd.getName())) {

            NetworkRequestaGenericPackage packData = cmd.execute(line, commandManager, scan); // ///////////////////////////

            serverRequestFlag = true;
            sendDataToServer(packData);
            serverRequestFlag = false;

            if (line.trim().equals("exit")) {
              break outerloop;
            }
            flag = false;
          }
        }
        if (flag) {
          System.out.println(ColorText.ColorPURPLE("Некорректно введенные данные!"));
        }

      } else {
        System.out.println(ColorText.ColorRED("Подождите пока сервер обработает запрос..."));
      }
    }
  }
}
