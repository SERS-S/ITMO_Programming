package CommandManager.CommandsStack.UpdateCommand;

import CollectionManager.ColorText;

public class LoyalCheck 
{
    public static boolean loyalCheck(String input)
    {
        if (input.trim().equals("true") || input.trim().equals("false"))
        {
            System.out.println(ColorText.ColorGREEN("Значение поля loyal обновлено"));
            return true;
        }
        else
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести loyal:"));
            return false;
        }
    }
}
