package Client;

import NetworkPackage.NetworkRequestGenericPackage;
import NetworkPackage.NetworkResponceGenericPackage;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.Command;
import ColorText.ColorResponce;
import ColorText.ColorText;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Scanner;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


public class Main {

    static boolean serverRequestFlag = false;
    static boolean isAuthorized = false;
    static String login;
    static String password;
    
    public static void main(String[] args) {

        CommandManager commandManager = new CommandManager();

        Scanner scan = new Scanner(System.in);
        System.out.println(ColorText.ColorCYAN("> Интерактивная консоль запущена..."));
        System.out.println(ColorText.ColorCYAN("> Для работы с коллекцией авторизуйтесь: (введите режим {a/r}, логин и пароль через пробел)"));

        outerloop:
        while (true) {
            String line = scan.nextLine();
            if (!serverRequestFlag) {
                if (isAuthorized) {
                    boolean flag = true;
                    for (Command cmd : commandManager.getCommandsList()) {
                        if (line.contains(cmd.getName())) {

                            NetworkRequestGenericPackage packData = cmd.execute(line, commandManager, scan);
                            packData.setClientUser(login, password);

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
                } else if (!isAuthorized) {
                    try {
                        if (checkAuthorization(line)) {
                            isAuthorized = true;
                        } else {
                            System.out.println(ColorText.ColorRED("Введены некорректные данные для авторизации!"));
                        }
                    } catch (Exception e) {
                        System.out.println(ColorText.ColorRED(e.getMessage()));
                    }
                }
            } else {
                System.out.println(ColorText.ColorRED("Подождите пока сервер обработает запрос..."));
            }
        }
    }

    public static boolean checkAuthorization(String line) {
        String[] loginPassword = line.split(" ");
        if ((loginPassword.length == 3) && ((loginPassword[0].equalsIgnoreCase("a")) || loginPassword[0].equalsIgnoreCase("r")) && (!loginPassword[1].equalsIgnoreCase("")) && (!loginPassword[2].equalsIgnoreCase(""))) {
            if (loginPassword[0].equalsIgnoreCase("a")) {
                NetworkRequestGenericPackage packOne = new NetworkRequestGenericPackage("identificationPackage", "authorization", loginPassword[1].trim(), loginPassword[2].trim());
                if (sendIdentificationRequestToServer(packOne)) {
                    login = line.split(" ")[1].trim();
                    password = line.split(" ")[2].trim();
                    return true;
                } else {
                    return false;
                }
            } else if (loginPassword[0].equalsIgnoreCase("r")) {
                NetworkRequestGenericPackage packOne = new NetworkRequestGenericPackage("identificationPackage", "registration", loginPassword[1].trim(), loginPassword[2].trim());
                if (sendIdentificationRequestToServer(packOne)) {
                    login = line.split(" ")[1].trim();
                    password = line.split(" ")[2].trim();
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public static void sendDataToServer(NetworkRequestGenericPackage packData) {
        System.out.println(ColorText.ColorPURPLE("  > ") + ColorText.ColorGREEN("Отправение данных на сервер..."));
    
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
            NetworkResponceGenericPackage responceDataPack = (NetworkResponceGenericPackage) ois.readObject();
    
            ColorResponce.ColorOutputText(responceDataPack.getResponceStrings());
          }
    
          oos.close();
          sock.close();
    
        } catch (Exception e) {
          System.out.println(ColorText.ColorRED("Ошибка при отправке данных на сервер!"));
        }
    
        System.out.println("~ " + ColorText.ColorBLUE("Итерация по введенным данным в консоли прошла!"));
      }

      public static boolean sendIdentificationRequestToServer(NetworkRequestGenericPackage packData) throws RuntimeException {
        System.out.println(ColorText.ColorPURPLE("  > ") + ColorText.ColorGREEN("Проверка данных на сервере..."));

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
      
            ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
            NetworkResponceGenericPackage responceDataPack = (NetworkResponceGenericPackage) ois.readObject();
    
            ColorResponce.ColorOutputText(responceDataPack.getResponceStrings());
            return responceDataPack.getValidAutharizationRegistration();

        } catch (ConnectException ce) {
            throw new RuntimeException("Не удалось подключиться к серверу!");
            // System.err.println("Не удалось подключиться к серверу: " + ce.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка ввода-вывода при работе с сервером");
        }
      }

}
