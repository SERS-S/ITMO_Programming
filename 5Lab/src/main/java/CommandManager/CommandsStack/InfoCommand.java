package CommandManager.CommandsStack;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

/**
 * Класс команды InfoCommand
 */
public class InfoCommand implements Command
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
        return "info";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("info"))
            {
                System.out.println(ColorText.ColorGREEN("Информация о коллекции:"));
                System.out.println("  > " + ColorText.ColorGREEN("Тип: SpaceMarine {id, name, coordinates, creationDate, health, loyal, achivements, weaponType, chapter}"));
                if (collectionManager.getCollection().size() != 0)
                {
                    System.out.println("  > " + ColorText.ColorGREEN("Дата инициализации:" + " " + collectionManager.getCollection().get(0).getDateCreation()));
                    System.out.println("  > " + ColorText.ColorGREEN("Количество элементов:" + " " + collectionManager.getCollection().size()));
                }
                else
                {
                    System.out.println("  > " + ColorText.ColorGREEN("Дата инициализации:" + " ") + ColorText.ColorRED("информация отсутствует"));
                    System.out.println("  > " + ColorText.ColorGREEN("Количество элементов:" + " ") + ColorText.ColorRED("0"));
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда info")); }
    }
}
