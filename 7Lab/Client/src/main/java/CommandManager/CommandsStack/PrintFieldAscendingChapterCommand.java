package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Scanner;

public class PrintFieldAscendingChapterCommand implements Command {
  @Override
  public String getName() {
    return "print_field_ascending_chapter";
  }

  @Override
  public NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scan) {
    boolean flag;

    if (line.trim().equals("print_field_ascending_chapter")) {
      flag = true;
    } else {
      flag = false;
      System.out.println(
          ColorText.ColorRED("некорректна введена команда print_field_ascending_chapter"));
    }

    NetworkRequestGenericPackage packData = new NetworkRequestGenericPackage("dataPackage", "print_field_ascending_chapter", flag);
    return packData;
  }
}
