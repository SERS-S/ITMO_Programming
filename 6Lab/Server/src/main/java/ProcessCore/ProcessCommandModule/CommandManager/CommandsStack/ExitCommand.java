package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class ExitCommand implements Command {
  @Override
  public String getName() {
    return "exit";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    responceStrings.add("GREEN#" + "  > Завершение клиентсого приложения");

    return responceStrings;
  }
}
