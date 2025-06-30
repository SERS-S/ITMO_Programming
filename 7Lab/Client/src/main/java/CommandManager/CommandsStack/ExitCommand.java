package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Scanner;

public class ExitCommand implements Command {
  @Override
  public String getName() {
    return "exit";
  }

  @Override
  public NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("exit")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда exit"));
    }

    NetworkRequestGenericPackage packData = new NetworkRequestGenericPackage("dataPackage", "exit", flag);
    return packData;
  }
}
