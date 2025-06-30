package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CommandManager.CommandManager;
import CollectionManager.ColorText;
import SpaceMarine.SpaceMarine;

/**
 * Класс команды Remove_by_idCommand
 */
public class RemoveByIdCommand implements Command
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
        return "remove_by_id";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if ((line.split(" ").length == 2) && (line.split(" ")[0].equals("remove_by_id"))) 
            {
                if (collectionManager.getCollection().size() != 0)
                {
                    boolean id_flag = false;
                    for (SpaceMarine el : collectionManager.getCollection())
                    {
                        if (line.split(" ")[1].equals(el.getLineData().split(" ")[0]))
                        {
                            id_flag = true;
                        }
                    }
                    if (!id_flag) { throw new IOException(); }

                    collectionManager.deleteElementById(line.split(" ")[1]);
                    System.out.println("  > " + ColorText.ColorGREEN("Элемент коллекции с id ") + line.split(" ")[1] + ColorText.ColorGREEN(" успешно удален"));
                }
                else
                {
                    System.out.println("  > " + ColorText.ColorRED("Удаление элемента коллекции невозможно. Коллекция пуста!"));
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда remove_by_id")); }
    }
}
