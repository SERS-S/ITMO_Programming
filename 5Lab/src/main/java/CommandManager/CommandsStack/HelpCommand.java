package CommandManager.CommandsStack;

import CollectionManager.ColorText;
import CommandManager.CommandManager;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;

/**
 * Класс команды HelpCommand
 */
public class HelpCommand implements Command
{
     /**
     * Выполняет команду add
     *
     * @param mainLine 1-я строка
     * @param consoleManager 2-я переменная типа <CollectionManager>
     * @param scanner 3-я переменная типа <Scanner>
     */

    @Override
    public String getName()
    {
        return "help";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("help"))
            {
                System.out.println(ColorText.ColorGREEN("Доступны следующие команды:"));
                for (Command cmd : commandManager.getCommandsList())
                {
                    System.out.println("  > " + ColorText.ColorGREEN(cmd.getName()));
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда help")); }
    }
}
