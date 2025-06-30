package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class RemoveFirstCommand implements Command {
  @Override
  public String getName() {
    return "remove_first";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("remove_first")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда remove_first"));
    }

    NetworkRequestaGenericPackage packData =
        new NetworkRequestaGenericPackage("remove_first", flag);
    return packData;
  }
}
