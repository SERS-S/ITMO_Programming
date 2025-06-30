package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.DataBaseManagerModule.DataBaseConnection;
import ProcessCore.DataBaseManagerModule.StatementConnection;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class RemoveFirstCommand implements Command {
  @Override
  public String getName() {
    return "remove_first";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {

    ArrayList<String> responceStrings = new ArrayList<String>();
    DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "5432", "studs");
    StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());

    try {

      if (collectionManager.getCollection().size() == 0) {
        responceStrings.add("RED#" + "  > " + "Удаление элемента коллекции невозможно. Коллекция пуста!");
        return responceStrings;
      }
      
      if (collectionManager.getCollection().get(0).getLineData().split(" ")[9].equals(packOne.getClientUser().getLogin())) {

        statementConnection.removeByIdEelement(packOne.getDataStrings()[0]);
        collectionManager.deleteElementById(packOne.getDataStrings()[0]);

        responceStrings.add("GREEN#" + "  > " + "Первый элемент коллекции с id: " + packOne.getDataStrings()[0] + " успешно удален");
      } else {
        responceStrings.add("RED#" + "  > " + "Удаление элемента коллекции невозможно. Отсутствует разрешение для элемента с id: " + packOne.getDataStrings()[0]);
      }

    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда remove_first");
    }

    return responceStrings;
  }
}
