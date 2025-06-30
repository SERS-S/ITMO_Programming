package CommandManager.CommandsStack.UpdateCommand;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.Command;
import SpaceMarine.SpaceMarine;

/**
 * Класс команды AddCommand
 */
public class UpdateCommand implements Command
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
        return "update";
    }

    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if ((line.split(" ").length == 3) && (line.split(" ")[0].equals("update")))
            {
                if (collectionManager.getCollection().size() != 0)
                {
                    boolean id_flag = false;
                    for (SpaceMarine el : collectionManager.getCollection())
                    {
                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0])))
                        {
                            id_flag = true;
                        }
                    }
                    if (!id_flag) { throw new IOException(); }

                    if (Arrays.asList("name", "coordinates", "health", "loyal", "achievements", "weaponType", "chapter").contains(line.split(" ")[2].trim()))
                    {
                        System.out.println("  > " + ColorText.ColorGREEN("Введите новое значение поля ") + line.split(" ")[2].trim() + ColorText.ColorGREEN(" элемента:"));
                    }
                    else { throw new IOException(); }

                    int i_count = -1;
                    while (true)
                    {
                        if (i_count != -1)
                        {
                            String input = scanner.nextLine();
                            if (input.equals("/stop"))
                            {
                                System.out.println("Процесс ввода данных для команды update прерван");
                                break;
                            }

                            if (line.split(" ")[2].trim().equals("name"))
                            {
                                if (NameCheck.nameCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0]))) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input.trim()); }
                                    }
                                    break;
                                }
                            }

                            if (line.split(" ")[2].trim().equals("coordinates"))
                            {
                                if (CoordinatesCheck.coordinatesCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0]))) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input.trim()); }
                                    }
                                    break;
                                }
                            }

                            if (line.split(" ")[2].trim().equals("health"))
                            {
                                if (HealthCheck.healthCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0])))
                                        {
                                            if (input.trim().equals("")) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], "null"); }
                                            else { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input); }
                                        }
                                    }
                                    break;
                                }
                            }

                            if (line.split(" ")[2].trim().equals("loyal"))
                            {
                                if (LoyalCheck.loyalCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0]))) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input.trim()); }
                                    }
                                    break;
                                }
                            }

                            if (line.split(" ")[2].trim().equals("achievements"))
                            {
                                if (AchievementsCheck.achievementsCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0]))) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input.trim()); }
                                    }
                                    break;
                                }
                            }

                            if (line.split(" ")[2].trim().equals("weaponType"))
                            {
                                if (WeaponTypeCheck.weaponTypeCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0]))) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input.trim()); }
                                    }
                                    break;
                                }
                            }

                            if (line.split(" ")[2].trim().equals("chapter"))
                            {
                                if (ChapterCheck.chapterCheck(input))
                                {
                                    for (SpaceMarine el : collectionManager.getCollection())
                                    {
                                        if (line.split(" ")[1].equals(String.valueOf(el.getLineData().split(" ")[0]))) { collectionManager.updateCollectionEelement(line.split(" ")[1], line.split(" ")[2], input.trim()); }
                                    }
                                    break;
                                }
                            }
                        }
                        else if (i_count == -1)
                        {
                            ++i_count;
                            continue;
                        }
                    }
                }
                else
                {
                    System.out.println("  > " + ColorText.ColorRED("Обновление коллекции невозможно. Коллекция пуста!"));
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда update")); }
    }
}
