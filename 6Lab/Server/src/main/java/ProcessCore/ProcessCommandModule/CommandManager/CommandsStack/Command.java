package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public interface Command {
  String getName();

  ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager);
}
