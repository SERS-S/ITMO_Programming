package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class ClearCommand implements Command {
  @Override
  public String getName() {
    return "clear";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      collectionManager.getCollection().clear();
      responceStrings.add("GREEN#" + "  > " + "Все элементы коллекции успешно удалены");
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда clear");
    }

    return responceStrings;
  }
}
