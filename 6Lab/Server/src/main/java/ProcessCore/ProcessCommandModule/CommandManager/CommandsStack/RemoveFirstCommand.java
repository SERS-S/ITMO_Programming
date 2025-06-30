package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class RemoveFirstCommand implements Command {
  @Override
  public String getName() {
    return "remove_first";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {

    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      collectionManager.deleteElementById(collectionManager.getCollection().get(0).getLineData().split(" ")[0]);
      responceStrings.add("GREEN#" + "  > " + "Успешно удален первый элемент коллекции");
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда remove_first");
    }

    return responceStrings;
  }
}
