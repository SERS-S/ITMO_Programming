package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.DataBaseManagerModule.DataBaseConnection;
import ProcessCore.DataBaseManagerModule.StatementConnection;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

public class RemoveLowerCommand implements Command {
  @Override
  public String getName() {
    return "remove_lower";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();
    DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "5432", "studs");
    StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());

    try {
      if (collectionManager.getCollection().size() == 0) {
        responceStrings.add("RED#" + "Коллекция пуста");
        return responceStrings;
      }

      try {
        Integer.valueOf(packOne.getDataStrings()[0]);
      } catch (NumberFormatException e) {
        responceStrings.add("RED#" + "Некоректно введен номер элемента");
        return responceStrings;
      }

      if ((Integer.valueOf(packOne.getDataStrings()[0]) <= 0) || (Integer.valueOf(packOne.getDataStrings()[0]) > collectionManager.getCollection().size())) {
        responceStrings.add("RED#" + "Некоректно введен номер элемента");
        return responceStrings;
      } else {
        for (int i = 0; i < (Integer.valueOf(packOne.getDataStrings()[0]) - 1); ++i) {
          System.out.println("элемент с id: " + collectionManager.getCollection().get(i).getLineData());
          Vector<SpaceMarine> temporary_collection = collectionManager.getCollection();
          temporary_collection.sort(Comparator.naturalOrder());

          if (collectionManager.getCollection().get(i).getLineData().split(" ")[9].equals(packOne.getClientUser().getLogin())) {
            statementConnection.removeByIdEelement(temporary_collection.get(i).getLineData().split(" ")[0]);
            collectionManager.deleteElementById(temporary_collection.get(i).getLineData().split(" ")[0]);
          }

        }
        responceStrings.add("GREEN#" + "  > " + "Все допустимые предшествующие элементы успешно удалены");
      }
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда remove_lower");
    }

    return responceStrings;
  }
}
