package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class ClearCommand implements Command {
  @Override
  public String getName() {
    return "clear";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("clear")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда clear"));
    }

    NetworkRequestaGenericPackage packData = new NetworkRequestaGenericPackage("clear", flag);
    return packData;
  }
}
