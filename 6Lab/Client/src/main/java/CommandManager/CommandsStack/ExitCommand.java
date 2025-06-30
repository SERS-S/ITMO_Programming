package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class ExitCommand implements Command {
  @Override
  public String getName() {
    return "exit";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("exit")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда exit"));
    }

    NetworkRequestaGenericPackage packData = new NetworkRequestaGenericPackage("exit", flag);
    return packData;
  }
}
