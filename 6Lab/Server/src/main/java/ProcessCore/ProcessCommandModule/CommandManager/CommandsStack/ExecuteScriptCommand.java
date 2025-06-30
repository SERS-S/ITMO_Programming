package ProcessCore.ProcessCommandModule.CommandManager.CommandsStack;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;

import java.util.ArrayList;

public class ExecuteScriptCommand implements Command {
  @Override
  public String getName() {
    return "execute_script";
  }

  @Override
  public ArrayList<String> execute(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne, CommandManager commandManager) {

    ArrayList<String> responceStrings = new ArrayList<String>();

    try {
      responceStrings.add("YELLOW#" + ">>> " + "Запущен процесс построчной интерпретации команд файла:");
      ArrayList<String> scriptLines = packOne.getScriptLines();
      for (int i = 0; i < scriptLines.size(); ++i) {
        responceStrings.add("YELLOW#" + "Содержимое строки: " + scriptLines.get(i));

        if (scriptLines.get(i).contains("execute_script")) {
          responceStrings.add("RED#" + "Содержимое строки проигнорировано. Рекурсия недопустима");
          continue;
        } else if (scriptLines.get(i).trim().equals("add")) {
          NetworkRequestaGenericPackage addCommandPack = new NetworkRequestaGenericPackage("add", true);
          addCommandPack.getMainData(
              "-",
              scriptLines.get(i + 1),
              scriptLines.get(i + 2),
              scriptLines.get(i + 3),
              scriptLines.get(i + 4),
              scriptLines.get(i + 5),
              scriptLines.get(i + 6),
              scriptLines.get(i + 7));

          responceStrings.addAll((new AddCommand()).execute(collectionManager, addCommandPack, commandManager));
          i += 7;
        } else {
          for (Command cmd : commandManager.getCommandsList()) {
            responceStrings.addAll(cmd.execute(collectionManager, packOne, commandManager));
            break;
          }
        }
      }
    } catch (Exception e) {
      responceStrings.add("RED#" + "Некорректна введена команда execute_script");
    }

    return responceStrings;
  }
}
