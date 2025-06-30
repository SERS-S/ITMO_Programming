package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class RemoveByIdCommand implements Command {
  @Override
  public String getName() {
    return "remove_by_id";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      if (collectionManager.getCollection().size() != 0) {
        boolean idFlag = false;
        idFlag = collectionManager.getCollection().stream().anyMatch(el -> packOne.getDataStrings()[0].equals(el.getLineData().split(" ")[0]));
        if (!idFlag) {
          responceStrings.add("RED#" + "  > " + "Удаление элемента коллекции невозможно. Отсутствует элемент с id: " + packOne.getDataStrings()[0]);
          return responceStrings;
        }

        collectionManager.deleteElementById(packOne.getDataStrings()[0]);
        responceStrings.add("GREEN#" + "  > " + "Элемент коллекции с id: " + packOne.getDataStrings()[0] + " успешно удален");
      } else {
        responceStrings.add("RED#" + "  > " + "Удаление элемента коллекции невозможно. Коллекция пуста!");
      }
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда remove_by_id");
    }

    return responceStrings;
  }
}
