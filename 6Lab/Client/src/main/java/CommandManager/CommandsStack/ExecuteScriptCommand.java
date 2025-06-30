package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
  @Override
  public String getName() {
    return "execute_script";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;
    ArrayList<String> commandsArray = new ArrayList<String>();

    if ((line.split(" ").length == 2)
        && (line.split(" ")[0].trim().equals("execute_script"))
        && (!line.split(" ")[1].trim().equals(""))) {
      if ((new File(line.split(" ")[1].trim())).exists()) {
        flag = true;
        try {
          Scanner fileScan = new Scanner(new File(line.split(" ")[1].trim()));
          while (fileScan.hasNextLine()) {
            commandsArray.add(fileScan.nextLine());
          }
          fileScan.close();
        } catch (Exception e) {
          flag = false;
          System.out.println(ColorText.ColorRED("ошибка при чтении файла"));
        }
      } else {
        flag = false;
        System.out.println(ColorText.ColorRED("некорректно введен путь к файлу"));
      }
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда execute_script"));
    }

    NetworkRequestaGenericPackage packData =
        new NetworkRequestaGenericPackage("execute_script", flag);
    if (flag) {
      packData.getScriptData(commandsArray);
    }
    return packData;
  }
}
