package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

public class PrintAscendingCommand implements Command {
  @Override
  public String getName() {
    return "print_ascending";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      Vector<SpaceMarine> temporaryCollection = collectionManager.getCollection();
      temporaryCollection.sort(Comparator.naturalOrder());
      responceStrings.add("GREEN#" + " > " + "Список элементов коллекции в возрастающем порядке:");
      IntStream.range(0, temporaryCollection.size()).mapToObj(i -> "GREEN#" + "  " + String.valueOf(i + 1) + ": {" + temporaryCollection.get(i).getLineData() + "}").forEach(responceStrings::add);
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда print_ascending");
    }

    return responceStrings;
  }
}
