package CommandManager.CommandsStack;

import CommandManager.CommandManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public interface Command {
  String getName();

  NetworkRequestaGenericPackage execute(String line, CommandManager commandManager, Scanner scan);
}
