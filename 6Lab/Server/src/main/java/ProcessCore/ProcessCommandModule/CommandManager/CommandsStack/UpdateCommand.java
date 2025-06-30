package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class UpdateCommand implements Command {
  @Override
  public String getName() {
    return "update";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      boolean idFlag = false;
      idFlag = collectionManager.getCollection().stream().anyMatch(el -> packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0])));
      if (!idFlag) {
        responceStrings.add("Ошибка: элемент с таким id не найден");
        return responceStrings;
      }

      if (!packOne.getDataStrings()[1].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "name", packOne.getDataStrings()[1]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

      if (!packOne.getDataStrings()[2].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "coordinates", packOne.getDataStrings()[2]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

      if (!packOne.getDataStrings()[3].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "health", packOne.getDataStrings()[3]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

      if (!packOne.getDataStrings()[4].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "loyal", packOne.getDataStrings()[4]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

      if (!packOne.getDataStrings()[5].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "achievements", packOne.getDataStrings()[5]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

      if (!packOne.getDataStrings()[6].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "weaponType", packOne.getDataStrings()[6]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

      if (!packOne.getDataStrings()[7].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            collectionManager.updateCollectionEelement(packOne.getDataStrings()[0], "chapter", packOne.getDataStrings()[7]);
            responceStrings.add("Поле name успешно обновлено");
            return responceStrings;
          }
        }
      }

    } catch (Exception e) {
      responceStrings.add("Ошибка при выполнении команды update");
    }

    return responceStrings;
  }
}
