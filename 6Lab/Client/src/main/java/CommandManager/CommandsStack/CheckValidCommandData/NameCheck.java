package CommandManager.CommandsStack.CheckValidCommandData;

import ColorText.ColorText;

public class NameCheck {
  public static boolean nameCheck(String input) {
    if (input.trim().isEmpty() || input.trim().equalsIgnoreCase("null")) {
      System.out.println(
          ColorText.ColorRED("Некорректно введены данные")
              + ColorText.ColorYELLOW(" Попробуйте еще раз ввести name:"));
      return false;
    } else {
      System.out.println(ColorText.ColorGREEN("name получен"));
      return true;
    }
  }
}
