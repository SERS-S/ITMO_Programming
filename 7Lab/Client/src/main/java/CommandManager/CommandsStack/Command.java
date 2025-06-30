package CommandManager.CommandsStack;

import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Scanner;

public interface Command {
  String getName();

  NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scan);
}
