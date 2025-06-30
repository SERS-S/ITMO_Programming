package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Scanner;

public class ClearCommand implements Command {
  @Override
  public String getName() {
    return "clear";
  }

  @Override
  public NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("clear")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда clear"));
    }

    NetworkRequestGenericPackage packData = new NetworkRequestGenericPackage("dataPackage", "clear", flag);
    return packData;
  }
}
