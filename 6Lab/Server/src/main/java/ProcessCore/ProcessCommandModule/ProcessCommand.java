package ProcessCore.ProcessCommandModule;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestaGenericPackage;
import NetworkPackage.NetworkResponceGenericPackage;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.Command;

import java.util.ArrayList;

public class ProcessCommand {

  protected String commandName;
  protected Boolean correctCommand;

  protected ArrayList<String> responceStrings;

  public ProcessCommand(CollectionManager collectionManager, NetworkRequestaGenericPackage packOne) {

    CommandManager commandManager = new CommandManager();

    for (Command cmd : commandManager.getCommandsList()) {
      if (packOne.getCommandName().contains(cmd.getName())) {

        commandName = packOne.getCommandName();
        correctCommand = packOne.getCorrectedInputData();

        if (packOne.getCorrectedInputData()) {
          responceStrings = cmd.execute(collectionManager, packOne, commandManager);
        }

        break;
      }
    }
  }

  public NetworkResponceGenericPackage getNetworkResponcePack() {
    NetworkResponceGenericPackage networkResponceGenericPackage = new NetworkResponceGenericPackage(commandName, correctCommand);
    networkResponceGenericPackage.getResponceData(responceStrings);
    return networkResponceGenericPackage;
  }

  public Boolean getCorrectCommand() {
    return correctCommand;
  }
}
