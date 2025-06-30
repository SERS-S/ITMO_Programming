package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

/**
 * Класс команды ShowCommand
 */
public class ShowCommand implements Command
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
        return "show";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("show"))
            {
                System.out.println(ColorText.ColorGREEN("Элементы коллекции:"));
                for (int i = 0; i < collectionManager.getCollection().size(); ++i)
                {
                    System.out.println("  > " + ColorText.ColorGREEN("Содержание элемента номер " + String.valueOf(i + 1)) + " : {" + ColorText.ColorGREEN(String.valueOf(collectionManager.getCollection().get(i).getLineData())) + "}");
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда show")); }
    }
}
