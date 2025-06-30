package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class ShowCommand implements Command {
  @Override
  public String getName() {
    return "show";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("show")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда show"));
    }

    NetworkRequestaGenericPackage packData = new NetworkRequestaGenericPackage("show", flag);
    return packData;
  }
}
