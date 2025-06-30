package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class ExitCommand implements Command {
  @Override
  public String getName() {
    return "exit";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    responceStrings.add("GREEN#" + "  > Завершение клиентсого приложения");

    return responceStrings;
  }
}
