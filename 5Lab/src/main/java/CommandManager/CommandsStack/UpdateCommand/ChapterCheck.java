package CommandManager.CommandsStack.UpdateCommand;

import CollectionManager.ColorText;

public class ChapterCheck 
{
    public static boolean chapterCheck(String input)
    {
        if (input.trim().split("_").length == 2)
        {
            if ((!input.trim().split("_")[0].equalsIgnoreCase("")) && (!input.trim().split("_")[0].equalsIgnoreCase("null")))
            {
                System.out.println(ColorText.ColorGREEN("Значение поля weaponType обновлено"));
                return true;
            }
            else
            {
                System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести chapter:"));
                return false;
            }
        }
        else
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести chapter:"));
            return false;
        }
    }
}
