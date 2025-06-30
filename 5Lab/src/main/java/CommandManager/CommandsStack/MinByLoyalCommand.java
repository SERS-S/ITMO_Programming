package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

// выводит первый обьект коллекции с loyal = false 

/**
 * Класс команды Min_by_loyalCommand
 */
public class MinByLoyalCommand implements Command
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
        return "min_by_loyal";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("min_by_loyal"))
            {
                if (collectionManager.getCollection().size() == 0)
                {
                    System.out.println(ColorText.ColorRED("Выполнение команды невозможно. Коллекция пуста!"));
                }
                else
                {
                    boolean loyal_flag = false;
                    for (int i = 0; i < collectionManager.getCollection().size(); ++i)
                    {
                        if (collectionManager.getCollection().get(i).getLineData().split(" ")[5].equals("false"))
                        {
                            loyal_flag = true;
                            System.out.println("  > " + ColorText.ColorGREEN("Первый элемент под номером ") + String.valueOf(i + 1) + ColorText.ColorGREEN(". Содержимое: " + collectionManager.getCollection().get(i).getLineData()));
                        }
                    }
                    if (!loyal_flag)
                    {
                        System.out.println(ColorText.ColorRED("Не найдено элемента с loyal = false"));
                    }
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда min_by_loyal")); }
    }
}
