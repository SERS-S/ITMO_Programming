package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class MinByLoyalCommand implements Command {
  @Override
  public String getName() {
    return "min_by_loyal";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("min_by_loyal")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда min_by_loyal"));
    }

    NetworkRequestaGenericPackage packData =
        new NetworkRequestaGenericPackage("min_by_loyal", flag);
    return packData;
  }
}
