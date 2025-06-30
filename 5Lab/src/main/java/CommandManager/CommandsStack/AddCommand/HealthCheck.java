package CommandManager.CommandsStack.AddCommand;

import CollectionManager.ColorText;

public class HealthCheck 
{
    public static boolean healthCheck(String input)
    {
        if (input.trim().isEmpty() || input.trim().equals("null"))
        {
            System.out.println(ColorText.ColorGREEN("health получен"));
            System.out.println(ColorText.ColorYELLOW("Теперь введите loyal: (пример: true или false)"));
            System.out.println(1.1);
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

        if (health_flag && (Float.parseFloat(input) <= Float.MAX_VALUE) && (Float.parseFloat(input) >= Float.MIN_VALUE))
        {
            System.out.println(ColorText.ColorGREEN("health получен"));
            System.out.println(ColorText.ColorYELLOW("Теперь введите loyal: (пример: true или false)"));
            System.out.println(2.2);
            return true;
        }
        else
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести health:"));
            return false;
        }
    }
}
