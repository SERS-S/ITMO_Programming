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
 * Класс команды Remove_lowerCommand
 */
public class RemoveLowerCommand implements Command
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
        return "remove_lower";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if ((line.split(" ").length == 2) && (line.split(" ")[0].equals("remove_lower")))
            {
                if (collectionManager.getCollection().size() == 0)
                {
                    throw new IOException();
                }

                try 
                {
                    Integer.valueOf(line.split(" ")[1]);
                }
                catch (NumberFormatException e)
                {
                    throw new IOException();
                }

                if ((Integer.valueOf(line.split(" ")[1]) <= 0) || (Integer.valueOf(line.split(" ")[1]) > collectionManager.getCollection().size()))
                {
                    System.out.println(ColorText.ColorRED("Некоректно введен номер элемента"));
                }
                else
                {
                    for (int i = 0; i < (Integer.valueOf(line.split(" ")[1]) - 1); ++i)
                    {
                        Vector<SpaceMarine> temporary_collection = collectionManager.getCollection();
                        temporary_collection.sort(Comparator.naturalOrder());
                        collectionManager.deleteElementById(temporary_collection.get(i).getLineData().split(" ")[0]);
                        System.out.println("  > " + ColorText.ColorGREEN("Все предшествующие элементы успешно удалены"));
                    }
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда remove_lower")); }
    }
}
