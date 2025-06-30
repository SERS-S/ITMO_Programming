package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class AddCommand implements Command {
  @Override
  public String getName() {
    return "add";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {

    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      SpaceMarine one_new = new SpaceMarine(
        packOne.getDataStrings()[1],
        packOne.getDataStrings()[2],
        packOne.getDataStrings()[3],
        packOne.getDataStrings()[4],
        packOne.getDataStrings()[5],
        packOne.getDataStrings()[6],
        packOne.getDataStrings()[7]);
        
      collectionManager.addNewElement(one_new);
      responceStrings.add("GREEN#" + "  > " + "Новый элемент успешно добавлен!");
    } catch (Exception e) {
      responceStrings.add("RED#" + "  > " + "Ошибка при добавлении нового элемента!");
    }

    return responceStrings;
  }
}
