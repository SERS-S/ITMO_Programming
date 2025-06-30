package ProcessCore.ProcessCommandModule.CommandManager;

import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.AddCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.ClearCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.Command;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.ExecuteScriptCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.ExitCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.HelpCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.InfoCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.MinByLoyalCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.PrintAscendingCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.PrintFieldAscendingChapterCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.RemoveByIdCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.RemoveFirstCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.RemoveLastCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.RemoveLowerCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.ShowCommand;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.UpdateCommand;

import java.util.List;
import java.util.Vector;

public class CommandManager {
  private Vector<Command> commands = new Vector<>(
    List.of(
        new HelpCommand(),
        new InfoCommand(),
        new ShowCommand(),
        new AddCommand(),
        new UpdateCommand(),
        new RemoveByIdCommand(),
        new ClearCommand(),
        new ExecuteScriptCommand(),
        new ExitCommand(),
        new RemoveFirstCommand(),
        new RemoveLastCommand(),
        new RemoveLowerCommand(),
        new MinByLoyalCommand(),
        new PrintAscendingCommand(),
        new PrintFieldAscendingChapterCommand()));

  public Vector<Command> getCommandsList() {
    return commands;
  }
}
