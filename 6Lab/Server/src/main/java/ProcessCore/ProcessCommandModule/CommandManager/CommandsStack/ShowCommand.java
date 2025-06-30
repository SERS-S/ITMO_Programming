package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.stream.IntStream;
import java.util.ArrayList;

public class ShowCommand implements Command {
  @Override
  public String getName() {
    return "show";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {

    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      if (collectionManager.getCollection().size() == 0) {
        responceStrings.add("RED#" + "Коллекция пуста");
        return responceStrings;
      }

      responceStrings.add("GREEN#" + "Элементы коллекции:");
      IntStream
      .range(0, collectionManager.getCollection().size())
      .mapToObj(i -> "GREEN#" + "  > " + "Содержание элемента номер " + String.valueOf(i + 1) + " : {" + String.valueOf(collectionManager.getCollection().get(i).getLineData()) + "}")
      .forEach(responceStrings::add);
    } catch (Exception e) {
      responceStrings.add("RED#" + "некорректна введена команда show");
    }

    return responceStrings;
  }
}
