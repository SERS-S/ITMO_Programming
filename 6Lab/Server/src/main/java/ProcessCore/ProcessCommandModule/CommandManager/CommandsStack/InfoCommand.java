package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class InfoCommand implements Command {
  @Override
  public String getName() {
    return "info";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      responceStrings.add("GREEN#" + "Информация о коллекции:");
      responceStrings.add("GREEN#" + "  > " + "Тип: SpaceMarine {id, name, coordinates, creationDate, health, loyal, achivements, weaponType, chapter}");
      if (collectionManager.getCollection().size() != 0) {
        responceStrings.add("GREEN#" + "  > " + "Дата инициализации:" + " " + collectionManager.getCollection().get(0).getDateCreation());
        responceStrings.add("GREEN#" + "  > " + "Количество элементов:" + " " + collectionManager.getCollection().size());
      } else {
        responceStrings.add("RED#" + "  > " + "Дата инициализации:" + " " + "информация отсутствует");
        responceStrings.add("RED#" + "  > " + "Количество элементов:" + " " + "0");
      }
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда info");
    }

    return responceStrings;
  }
}
