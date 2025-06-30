package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;
import SpaceMarine.SpaceMarine;

/**
 * Класс команды Print_field_ascending_chapterCommand
 */
public class PrintFieldAscendingChapterCommand implements Command
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
        return "print_field_ascending_chapter";
    }
    
    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("print_field_ascending_chapter"))
            {
                Vector<SpaceMarine> temporary_collection = collectionManager.getCollection();
                temporary_collection.sort(Comparator.naturalOrder());
                System.out.println(" > " + ColorText.ColorGREEN("Список значений поля chapter элементов в возрастающем порядке:"));
                for (int i = 0; i < temporary_collection.size(); ++i)
                {
                    System.out.println("  " + String.valueOf(i + 1) + ": {" + ColorText.ColorGREEN(temporary_collection.get(i).getLineData().split(" ")[8]) + "}");
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда print_field_ascending_chapter")); }
    }
}
