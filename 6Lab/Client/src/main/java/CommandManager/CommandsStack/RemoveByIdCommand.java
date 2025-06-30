package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class RemoveByIdCommand implements Command {
  @Override
  public String getName() {
    return "remove_by_id";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if ((line.split(" ").length == 2)
        && (line.split(" ")[0].trim().equals("remove_by_id"))
        && (!line.split(" ")[1].trim().equals(""))) {
      flag = true;
    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда remove_by_id"));
    }

    NetworkRequestaGenericPackage packData =
        new NetworkRequestaGenericPackage("remove_by_id", flag);
    if (flag) {
      packData.getMainData(line.split(" ")[1], "-", "-", "-", "-", "-", "-", "-");
    }
    return packData;
  }
}
