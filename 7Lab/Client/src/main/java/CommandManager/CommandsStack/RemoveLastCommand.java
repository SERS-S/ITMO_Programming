package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Scanner;

public class RemoveLastCommand implements Command {
  @Override
  public String getName() {
    return "remove_last";
  }

  @Override
  public NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("remove_last")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда remove_last"));
    }

    NetworkRequestGenericPackage packData = new NetworkRequestGenericPackage("dataPackage", "remove_last", flag);
    return packData;
  }
}
