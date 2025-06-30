package CommandManager.CommandsStack.AddCommand;

import CollectionManager.ColorText;

public class LoyalCheck 
{
    public static boolean loyalCheck(String input)
    {
        if (input.trim().equals("true") || input.trim().equals("false"))
        {
            System.out.println(ColorText.ColorGREEN("loyal получен"));
            System.out.println(ColorText.ColorYELLOW("Теперь введите achievements:"));
            return true;
        }
        else
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести loyal:"));
            return false;
        }
    }
}
