package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.DataBaseManagerModule.DataBaseConnection;
import ProcessCore.DataBaseManagerModule.StatementConnection;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class ClearCommand implements Command {
  @Override
  public String getName() {
    return "clear";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();
    DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "5432", "studs");
    StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());

    try {
      statementConnection.truncateCollection(packOne.getClientUser().getLogin());

      collectionManager.getCollection().clear();
      responceStrings.add("GREEN#" + "  > " + "Все элементы коллекции, созданные пользователем, успешно удалены");
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда clear");
    }

    return responceStrings;
  }
}
