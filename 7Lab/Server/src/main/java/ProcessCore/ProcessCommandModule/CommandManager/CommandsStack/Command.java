package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public interface Command {
  String getName();

  ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager);
}
