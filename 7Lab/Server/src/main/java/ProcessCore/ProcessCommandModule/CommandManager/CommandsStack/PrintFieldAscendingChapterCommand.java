package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import Collection.SpaceMarine.SpaceMarine;
import NetworkPackage.NetworkRequestGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

public class PrintFieldAscendingChapterCommand implements Command {
  @Override
  public String getName() {
    return "print_field_ascending_chapter";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestGenericPackage packOne, CommandManager commandManager) {
    
    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      Vector<SpaceMarine> temporaryCollection = collectionManager.getCollection();
      temporaryCollection.sort(Comparator.naturalOrder());
      responceStrings.add("GREEN#" + " > " + "Список значений поля chapter элементов в возрастающем порядке:");
      IntStream.range(0, temporaryCollection.size()).mapToObj(i -> "GREEN#" + "  " + String.valueOf(i + 1) + ": {" + temporaryCollection.get(i).getLineData().split(" ")[8] + "}").forEach(responceStrings::add);
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда print_field_ascending_chapter");
    }

    return responceStrings;
  }
}
