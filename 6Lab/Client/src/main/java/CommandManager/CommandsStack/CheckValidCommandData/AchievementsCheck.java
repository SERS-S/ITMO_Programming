package CommandManager.CommandsStack.CheckValidCommandData;

import ColorText.ColorText;

public class AchievementsCheck {
  public static boolean achievementsCheck(String input) {
    if ((input.trim().equalsIgnoreCase("")) || (input.trim().equalsIgnoreCase("null"))) {
      System.out.println(
          ColorText.ColorRED("Некорректно введены данные")
              + ColorText.ColorYELLOW(" Попробуйте еще раз ввести achievements:"));
      return false;
    } else {
      System.out.println(ColorText.ColorGREEN("achievements получен"));
      return true;
    }
  }
}
