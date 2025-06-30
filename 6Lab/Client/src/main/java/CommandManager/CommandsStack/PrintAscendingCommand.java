package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class PrintAscendingCommand implements Command {
  @Override
  public String getName() {
    return "print_ascending";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("print_ascending")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда print_ascending"));
    }

    NetworkRequestaGenericPackage packData =
        new NetworkRequestaGenericPackage("print_ascending", flag);
    return packData;
  }
}
