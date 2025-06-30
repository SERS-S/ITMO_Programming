package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

/**
 * Класс команды Remove_firstCommand
 */
public class RemoveFirstCommand implements Command
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
        return "remove_first";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("remove_first"))
            {
                collectionManager.deleteElementById(collectionManager.getCollection().get(0).getLineData().split(" ")[0]);
                System.out.println("  > " + ColorText.ColorGREEN("Успешно удален первый элемент коллекции"));
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда remove_first")); }
    }
}
