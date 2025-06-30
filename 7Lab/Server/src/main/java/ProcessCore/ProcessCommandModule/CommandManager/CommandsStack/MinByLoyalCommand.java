package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class MinByLoyalCommand implements Command {
  @Override
  public String getName() {
    return "min_by_loyal";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      if (collectionManager.getCollection().size() == 0) {
        responceStrings.add("RED#" + "Выполнение команды невозможно. Коллекция пуста!");
      } else {
        boolean loyal_flag = false;
        for (int i = 0; i < collectionManager.getCollection().size(); ++i) {
          if (collectionManager.getCollection().get(i).getLineData().split(" ")[5].equals("false")) {
            loyal_flag = true;
            responceStrings.add("GREEN#" + "  > " + "Первый элемент под номером " + String.valueOf(i + 1) + ". Содержимое: " + collectionManager.getCollection().get(i).getLineData());
          }
        }
        if (!loyal_flag) {
          responceStrings.add("RED#" + "Не найдено элемента с loyal = false");
        }
      }
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда min_by_loyal");
    }

    return responceStrings;
  }
}
