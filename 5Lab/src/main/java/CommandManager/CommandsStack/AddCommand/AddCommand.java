package CommandManager.CommandsStack.AddCommand;

import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.Command;
import SpaceMarine.SpaceMarine;

/**
 * Класс команды AddCommand
 */
public class AddCommand implements Command
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
        return "add";
    }
    
    @Override
    public void execute(String mainLine, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (mainLine.trim().equals("add"))
            {
                String[] arr_new = new String[7];

                System.out.println(ColorText.ColorYELLOW("Введите name для нового элемента:"));
                int i_count = -1;
                while (true)
                {
                    if ((i_count != -1) && (i_count < 7))
                    {
                        String input = scanner.nextLine();
                        if (input.equals("/stop"))
                        {
                            System.out.println("Процесс ввода данных для команды add прерван");
                            break;
                        }

                        if (i_count == 0)
                        {
                            if (NameCheck.nameCheck(input))
                            {
                                arr_new[0] = input;
                                ++i_count;
                                continue;
                            }
                        }

                        if (i_count == 1)
                        {

                            if (CoordinatesCheck.coordinatesCheck(input))
                            {
                                arr_new[1] = "{" + input.replace("_", ";") + "}";
                                ++i_count;
                                continue;
                            }

                        }

                        if (i_count == 2)
                        {
                            if (HealthCheck.healthCheck(input))
                            {
                                if (input.trim().equals("")) { arr_new[2] = "null"; }
                                else { arr_new[2] = input; }
                                ++i_count;
                                continue;
                            }
                        }

                        if (i_count == 3)
                        {
                            if (LoyalCheck.loyalCheck(input))
                            {
                                arr_new[3] = input;
                                ++i_count;
                                continue;
                            }
                        }

                        if (i_count == 4)
                        {
                            if (AchievementsCheck.achievementsCheck(input))
                            {
                                arr_new[4] = input;
                                ++i_count;
                                continue;
                            }
                        }

                        if (i_count == 5)
                        {
                            if (WeaponTypeCheck.weaponTypeCheck(input))
                            {
                                arr_new[5] = input;
                                ++i_count;
                                continue;
                            }
                        }

                        if (i_count == 6)
                        {
                            if (ChapterCheck.chapterCheck(input))
                            {
                                arr_new[6] = "{" + input.replace("_", ";") + "}";
                                ++i_count;
                                continue;
                            }
                        }
                    }
                    else if (i_count == -1)
                    {
                        ++i_count;
                        continue;
                    }
                    else
                    {
                        SpaceMarine one_new = new SpaceMarine(arr_new[0], arr_new[1], arr_new[2], arr_new[3], arr_new[4], arr_new[5], arr_new[6]);
                        collectionManager.addNewElement(one_new);
                        System.out.println("  > " + ColorText.ColorGREEN("Новый элемент успешно добавлен!"));
                        break;
                    }
                } 
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда add")); }
    }
}
