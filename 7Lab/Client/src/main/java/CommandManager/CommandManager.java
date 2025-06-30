package CommandManager;

import CommandManager.CommandsStack.AddCommand;
import CommandManager.CommandsStack.ClearCommand;
import CommandManager.CommandsStack.Command;
import CommandManager.CommandsStack.ExecuteScriptCommand;
import CommandManager.CommandsStack.ExitCommand;
import CommandManager.CommandsStack.HelpCommand;
import CommandManager.CommandsStack.InfoCommand;
import CommandManager.CommandsStack.MinByLoyalCommand;
import CommandManager.CommandsStack.PrintAscendingCommand;
import CommandManager.CommandsStack.PrintFieldAscendingChapterCommand;
import CommandManager.CommandsStack.RemoveByIdCommand;
import CommandManager.CommandsStack.RemoveFirstCommand;
import CommandManager.CommandsStack.RemoveLastCommand;
import CommandManager.CommandsStack.RemoveLowerCommand;
import CommandManager.CommandsStack.ShowCommand;
import CommandManager.CommandsStack.UpdateCommand;
import java.util.List;
import java.util.Vector;

public class CommandManager {
  private Vector<Command> commands =
      new Vector<>(
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
