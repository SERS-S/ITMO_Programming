package CommandManager.CommandsStack.UpdateCommand;

import CollectionManager.ColorText;

public class CoordinatesCheck 
{
    public static boolean coordinatesCheck(String input)
    {
        boolean coordinates_flag = true;
        if ((input.split("_").length == 2))
        {                            
            try 
            {
                Integer.parseInt(input.split("_")[0]);
            } 
            catch (NumberFormatException e) 
            {
                coordinates_flag = false;
            }

            try 
            {
                Float.parseFloat(input.split("_")[1]);
            } 
            catch (NumberFormatException e) 
            {
                coordinates_flag = false;
            }

            if (coordinates_flag)
            {
                System.out.println(ColorText.ColorGREEN("Значение поля coordinates обновлено"));
                return true;
            }
            else
            {
                System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести coordinates:"));
                return false;
            }
        }
        else
        {
            System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести coordinates:"));
            return false;
        }
    }
}
