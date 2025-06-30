package CommandManager.CommandsStack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

/**
 * Класс команды SaveCommand
 */
public class SaveCommand implements Command
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
        return "save";
    }
    
    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if (line.trim().equals("save"))
            {
                String csvFile = "new_data.csv";

                if (collectionManager.getCollection().size() == 0)
                {
                    try (FileWriter writer = new FileWriter(csvFile)) 
                    {
                        writer.append(String.join(",", new String[] {"name", "coordinates", "health", "loyal", "achievements", "weaponType", "chpater"}));
                        System.out.println("  > " + ColorText.ColorGREEN("CSV файл успешно сохранён!"));
                    } 
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    String[][] data_to_save = new String[8][];
                    data_to_save[0] = new String[7];
                    for (int i = 1; i < 8; ++i)
                    {
                        data_to_save[i] = new String[collectionManager.getCollection().size()];
                    }

                    data_to_save[0][0] = "name";
                    data_to_save[0][1] = "coordinates";
                    data_to_save[0][2] = "health";
                    data_to_save[0][3] = "loyal";
                    data_to_save[0][4] = "achievements";
                    data_to_save[0][5] = "weaponType";
                    data_to_save[0][6] = "chapter";
                    
                    String[][] formated_collection = new String[collectionManager.getCollection().size()][7];
                    for (int j = 0; j < collectionManager.getCollection().size(); ++j)
                    {
                        formated_collection[j][0] = collectionManager.getCollection().get(j).getLineData().split(" ")[1];
                        formated_collection[j][1] = "{" + collectionManager.getCollection().get(j).getLineData().split(" ")[2] + "}";
                        formated_collection[j][2] = collectionManager.getCollection().get(j).getLineData().split(" ")[4];
                        formated_collection[j][3] = collectionManager.getCollection().get(j).getLineData().split(" ")[5];
                        formated_collection[j][4] = collectionManager.getCollection().get(j).getLineData().split(" ")[6];
                        formated_collection[j][5] = collectionManager.getCollection().get(j).getLineData().split(" ")[7];
                        formated_collection[j][6] = "{" + collectionManager.getCollection().get(j).getLineData().split(" ")[8] + "}";
                    }
                    
                    for (int i = 1; i < 8; ++i)
                    {
                        for (int ii = 0; ii < collectionManager.getCollection().size(); ++ii)
                        {
                            data_to_save[i][ii] = formated_collection[ii][i-1];
                        }
                    }

                    try 
                    (
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(csvFile))
                    ) 
                    {
                        for (String[] row : data_to_save) 
                        {
                            String line_to_write = String.join(",", row);
                            bos.write(line_to_write.getBytes(StandardCharsets.UTF_8));
                            bos.write("\n".getBytes(StandardCharsets.UTF_8));
                        }
                        bos.flush();
                        System.out.println("  > " + ColorText.ColorGREEN("CSV файл успешно сохранён!"));
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                throw new IOException();
            }
        }
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда save")); }
    }
}
