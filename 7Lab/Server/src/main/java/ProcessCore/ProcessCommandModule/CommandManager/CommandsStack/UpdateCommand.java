package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.DataBaseManagerModule.DataBaseConnection;
import ProcessCore.DataBaseManagerModule.StatementConnection;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class UpdateCommand implements Command {
  @Override
  public String getName() {
    return "update";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();
    DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "5432", "studs");
    StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());

    try {
      boolean idFlag = false;
      idFlag = collectionManager.getCollection().stream().anyMatch(el -> packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0])));
      if (!idFlag) {
        responceStrings.add("RED#" + "  > " + "Ошибка: элемент с таким id не найден");
        return responceStrings;
      }

      boolean idAllowedFlag = false;
      for (SpaceMarine spaceMarine : collectionManager.getCollection()) {
        if (spaceMarine.getLineData().split(" ")[9].equals(packOne.getClientUser().getLogin())) {
          idAllowedFlag = true;
        }
      }
      if (!idAllowedFlag) {
        responceStrings.add("RED#" + "  > " + "Ошибка: у вас нет прав на изменение этого элемента");
        return responceStrings;
      }

      if (!packOne.getDataStrings()[1].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "name", packOne.getDataStrings()[1]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "name", packOne.getDataStrings()[1]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле name не обновлено");
              return responceStrings;
            }
          }
        }
      }

      if (!packOne.getDataStrings()[2].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "coordinates", packOne.getDataStrings()[2]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "coordinates", packOne.getDataStrings()[2]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле coordinates не обновлено");
              return responceStrings;
            }
          }
        }
      }

      if (!packOne.getDataStrings()[3].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "health", packOne.getDataStrings()[3]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "health", packOne.getDataStrings()[3]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле health не обновлено");
              return responceStrings;
            }
          }
        }
      }

      if (!packOne.getDataStrings()[4].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "loyal", packOne.getDataStrings()[4]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "loyal", packOne.getDataStrings()[4]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле loyal не обновлено");
              return responceStrings;
            }
          }
        }
      }

      if (!packOne.getDataStrings()[5].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "achievements", packOne.getDataStrings()[5]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "achievements", packOne.getDataStrings()[5]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле achievements не обновлено");
              return responceStrings;
            }
          }
        }
      }

      if (!packOne.getDataStrings()[6].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "weaponType", packOne.getDataStrings()[6]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "weaponType", packOne.getDataStrings()[6]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле weaponType не обновлено");
              return responceStrings;
            }
          }
        }
      }

      if (!packOne.getDataStrings()[7].trim().equals("-")) {
        for (SpaceMarine el : collectionManager.getCollection()) {
          if (packOne.getDataStrings()[0].equals(String.valueOf(el.getLineData().split(" ")[0]))) {
            try {
              statementConnection.updateCollectionElement(packOne.getDataStrings()[0], "chapter", packOne.getDataStrings()[7]);

              collectionManager.updateCollectionElement(packOne.getDataStrings()[0], "chapter", packOne.getDataStrings()[7]);
              responceStrings.add("GREEN#" + "  > " + "Поле name успешно обновлено");
              return responceStrings;
            } catch (Exception e) {
              responceStrings.add("RED#" + "  > " + "Ошибка: поле chapter не обновлено");
              return responceStrings;
            }
          }
        }
      }

    } catch (Exception e) {
      responceStrings.add("RED#" + "  > " + "Ошибка при выполнении команды update");
    }

    return responceStrings;
  }
}
