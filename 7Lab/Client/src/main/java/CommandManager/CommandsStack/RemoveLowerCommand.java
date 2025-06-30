package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Scanner;

public class RemoveLowerCommand implements Command {
  @Override
  public String getName() {
    return "remove_lower";
  }

  @Override
  public NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if ((line.split(" ").length == 2)
        && (line.split(" ")[0].trim().equals("remove_lower"))
        && (!line.split(" ")[1].trim().equals(""))) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда remove_lower"));
    }

    NetworkRequestGenericPackage packData = new NetworkRequestGenericPackage("dataPackage", "remove_lower", flag);
    if (flag) {
      packData.getMainData(line.split(" ")[1], "-", "-", "-", "-", "-", "-", "-");
    }
    return packData;
  }
}
