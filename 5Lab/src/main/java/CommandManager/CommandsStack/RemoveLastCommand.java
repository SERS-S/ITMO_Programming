package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

/**
 * Класс команды Remove_lastCommand
 */
public class RemoveLastCommand implements Command
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
        return "remove_last";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("remove_last"))
            {
                collectionManager.deleteElementById(collectionManager.getCollection().get(collectionManager.getCollection().size() - 1).getLineData().split(" ")[0]);
                System.out.println("  > " + ColorText.ColorGREEN("Успешно удален последний элемент коллекции элемент коллекции"));
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда remove_last")); }
    }
}
