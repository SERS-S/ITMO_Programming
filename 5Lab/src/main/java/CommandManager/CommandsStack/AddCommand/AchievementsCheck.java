package CommandManager.CommandsStack.AddCommand;

import CollectionManager.ColorText;

public class AchievementsCheck 
{
    public static boolean achievementsCheck(String input)
    {
        if ((input.trim().equalsIgnoreCase("")) || (input.trim().equalsIgnoreCase("null")))
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести achievements:"));
            return false;
        }
        else
        {
            System.out.println(ColorText.ColorGREEN("achievements получен"));
            System.out.println(ColorText.ColorYELLOW("Теперь введите weaponType: (Варианты: BOLTGUN, COMBI_FLAMER, GRAV_GUN, GRENADE_LAUNCHER)"));
            return true;
        }
    }
}
