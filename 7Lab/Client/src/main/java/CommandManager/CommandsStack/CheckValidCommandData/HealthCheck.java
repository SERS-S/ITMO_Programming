package CommandManager.CommandsStack.CheckValidCommandData;

import ColorText.ColorText;

public class HealthCheck {
  public static boolean healthCheck(String input) {
    if (input.trim().isEmpty() || input.trim().equals("null")) {
      System.out.println(ColorText.ColorGREEN("health получен"));
      return true;
    }

    boolean health_flag = true;
    try {
      Float a = Float.valueOf(input);
      if (a <= 0.0) {
        health_flag = false;
      }
    } catch (NumberFormatException e) {
      health_flag = false;
    }

    if (health_flag && (Float.parseFloat(input) <= Float.MAX_VALUE) && (Float.parseFloat(input) >= Float.MIN_VALUE)) {
      System.out.println(ColorText.ColorGREEN("health получен"));
      return true;
    } else {
      System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести health:"));
      return false;
    }
  }
}
