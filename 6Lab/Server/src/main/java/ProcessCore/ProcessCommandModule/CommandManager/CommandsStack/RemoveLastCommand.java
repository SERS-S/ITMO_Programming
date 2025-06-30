package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class RemoveLastCommand implements Command {
  @Override
  public String getName() {
    return "remove_last";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {

    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      collectionManager.deleteElementById(collectionManager.getCollection().get(collectionManager.getCollection().size() - 1).getLineData().split(" ")[0]);
      responceStrings.add("GREEN#" + "  > " + "Успешно удален последний элемент коллекции элемент коллекции");
    } catch (Exception e) {
      responceStrings.add("RED#" + "некорректна введена команда remove_last");
    }

    return responceStrings;
  }
}
