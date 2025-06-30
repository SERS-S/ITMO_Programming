package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class RemoveLastCommand implements Command {
  @Override
  public String getName() {
    return "remove_last";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("remove_last")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда remove_last"));
    }

    NetworkRequestaGenericPackage packData = new NetworkRequestaGenericPackage("remove_last", flag);
    return packData;
  }
}
