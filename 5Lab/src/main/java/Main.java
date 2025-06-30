import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.Command;

/**
 * Основной класс
 */
public class Main
{
    public static void main(String[] args)
    {
        String path_to_file = System.getenv("CSV_FILE_PATH"); // /Users/sergey/Desktop/GitHub/Olimpics/ITMO/Programming/5Lab/src/main/java/data.csv
        try
        (
        InputStreamReader str = new InputStreamReader(new FileInputStream(path_to_file), "UTF-8");
        BufferedReader reader = new BufferedReader(str);
        )
        {
            CollectionManager collectionManager = new CollectionManager(CsvStreamToArray.readerToData(reader));       
            CommandManager commandManager = new CommandManager();     
            
            Scanner scanner = new Scanner(System.in);
            System.out.println(ColorText.ColorCYAN("> Консоль запущена..."));
            outerLoop: 
            while (true)
            {
                String line = scanner.nextLine();
                boolean flag = true;
                for (Command cmd : commandManager.getCommandsList())
                {
                    if (line.contains(cmd.getName())) 
                    {
                        cmd.execute(line, collectionManager, commandManager, scanner);
                        if (line.trim().equals("exit")) { break outerLoop; }
                        flag = false;
                    }
                }
                if (flag)
                {
                    System.out.println(ColorText.ColorPURPLE("Некорректно введенные данные!")); 
                }
                System.out.println("~ " + ColorText.ColorBLUE("Итерация по введенным данным в консоли прошла!"));
            }
        }
        catch (IOException e)
        {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
