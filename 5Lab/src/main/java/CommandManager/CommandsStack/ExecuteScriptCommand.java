package CommandManager.CommandsStack;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import CollectionManager.CollectionManager;
import CollectionManager.ColorText;
import CommandManager.CommandManager;

/**
 * Класс команды Execute_scriptCommand
 */
public class ExecuteScriptCommand implements Command
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
        return "execute_script";
    }
    
    @Override
    public void execute(String line, CollectionManager collectionManager, CommandManager commandManager, Scanner scanner)
    {
        try
        {
            if ((line.split(" ").length == 2) && (line.split(" ")[0].equals("execute_script")))
            {
                File file = new File(line.split(" ")[1]);
                if (!file.exists() || !file.isFile()) 
                {
                    System.out.println(ColorText.ColorRED("Файл " + line.split(" ")[1] + " не существует или не является файлом"));
                }
                else
                {
                    System.out.println(">>> " + ColorText.ColorYELLOW("Запущен процесс построчной интерпретации команд файла:"));
                    try 
                    (
                        FileInputStream fis = new FileInputStream(file);
                        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                        BufferedReader br = new BufferedReader(isr)
                    ) 
                    {
                        String current_line;
                        while ((current_line = br.readLine()) != null) {
                            System.out.println(ColorText.ColorYELLOW("Содержимое строки: ") + current_line);

                            byte[] lineBytes = (current_line).getBytes("UTF-8");
                            System.setIn(new ByteArrayInputStream(lineBytes));

                            try 
                            (
                                Scanner scan = new Scanner(System.in)
                            ) 
                            {
                                if (scan.hasNextLine()) 
                                {
                                    String inputLine = scan.nextLine();

                                    if (inputLine.contains("execute_script"))
                                    {
                                        System.out.println("  > " + ColorText.ColorRED("Содержимое строки проигнорировано. Рекурсия недопустима"));
                                        continue;
                                    }

                                    boolean flag = true;
                                    for (Command cmd : commandManager.getCommandsList())
                                    {
                                        if (inputLine.contains(cmd.getName()))
                                        {
                                            cmd.execute(inputLine, collectionManager, commandManager, scan);
                                            if (inputLine.trim().equals("exit")) { break; }
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
                        }
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
        catch (IOException e) { System.out.println(ColorText.ColorRED("некорректна введена команда execute_script")); }
    }
}
