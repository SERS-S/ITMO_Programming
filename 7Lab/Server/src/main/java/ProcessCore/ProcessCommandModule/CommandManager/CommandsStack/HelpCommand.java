package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class HelpCommand implements Command {
  @Override
  public String getName() {
    return "help";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      responceStrings.add("GREEN#" + "Доступны следующие команды:");
      commandManager.getCommandsList().stream().map(cmd -> "GREEN#" + "  > " + cmd.getName()).forEach(responceStrings::add);
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда help");
    }

    return responceStrings;
  }
}
