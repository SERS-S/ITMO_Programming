package CommandManager.CommandsStack.CheckValidCommandData;

import ColorText.ColorText;

public class CoordinatesCheck {
  public static boolean coordinatesCheck(String input) {
    if ((input.split("_").length == 2)) {
      boolean coordinates_flag = true;
      try {
        Integer.parseInt(input.split("_")[0]);
      } catch (NumberFormatException e) {
        coordinates_flag = false;
      }

      try {
        Float.parseFloat(input.split("_")[1]);
      } catch (NumberFormatException e) {
        coordinates_flag = false;
      }

      if (coordinates_flag
          && (Integer.parseInt(input.split("_")[0]) <= Integer.MAX_VALUE)
          && (Integer.parseInt(input.split("_")[0]) >= Integer.MIN_VALUE)
          && (Float.parseFloat(input.split("_")[1]) <= Float.MAX_VALUE)
          && (Float.parseFloat(input.split("_")[1]) >= Float.MIN_VALUE)) {
        System.out.println(ColorText.ColorGREEN("coordinates получены"));
        return true;
      } else {
        System.out.println(
            ColorText.ColorRED("Некорректно введены данные")
                + ColorText.ColorYELLOW(" Попробуйте еще раз ввести coordinates:"));
        return false;
      }
    } else {
      System.out.println(
          ColorText.ColorRED("Некорректно введены данные")
              + ColorText.ColorYELLOW(" Попробуйте еще раз ввести coordinates:"));
      return false;
    }
  }
}
