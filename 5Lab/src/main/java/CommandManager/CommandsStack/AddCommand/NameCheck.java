package CommandManager.CommandsStack.AddCommand;

import CollectionManager.ColorText;

public class NameCheck 
{
    public static boolean nameCheck(String input)
    {
        if (input.trim().isEmpty() || input.trim().equalsIgnoreCase("null")) 
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести name:"));
            return false;
        }
        else
        {
            System.out.println(ColorText.ColorGREEN("name получен"));
            System.out.println(ColorText.ColorYELLOW("Теперь введите coordinates: (пример 3_4.5)"));
            return true;
        }
    }
}
