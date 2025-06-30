package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class InfoCommand implements Command {
  @Override
  public String getName() {
    return "info";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("info")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда info"));
    }

    NetworkRequestaGenericPackage packData = new NetworkRequestaGenericPackage("info", flag);
    return packData;
  }
}
