package CommandManager.CommandsStack.UpdateCommand;

import CollectionManager.ColorText;

public class HealthCheck 
{
    public static boolean healthCheck(String input)
    {
        if (input.trim().isEmpty() || input.trim().equals("null"))
        {
            System.out.println(ColorText.ColorGREEN("Значение поля health обновлено"));
            return true;
        }

        boolean health_flag = true;
        try
        {
            Float a = Float.valueOf(input);
            if (a <= 0.0)
            {
                health_flag = false;
            }
        }
        catch (NumberFormatException e)
        {
            health_flag = false;
        }

        if (health_flag)
        {
            System.out.println(ColorText.ColorGREEN("Значение поля health обновлено"));
            return true;
        }
        else
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести health:"));
            return false;
        }
    }
}
