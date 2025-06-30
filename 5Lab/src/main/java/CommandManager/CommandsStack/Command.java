package CommandManager.CommandsStack;

import java.util.Scanner;

import CollectionManager.CollectionManager;
import CommandManager.CommandManager;

/**
 * Интерфейс команды Command
 */
public interface Command
{
    String getName();
    void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner);
}
