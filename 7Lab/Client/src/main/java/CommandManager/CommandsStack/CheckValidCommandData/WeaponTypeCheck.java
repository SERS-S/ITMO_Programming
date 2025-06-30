package CommandManager.CommandsStack.CheckValidCommandData;

import ColorText.ColorText;

public class WeaponTypeCheck {
  public static boolean weaponTypeCheck(String input) {
    if (input.trim().equals("BOLTGUN")
        || input.trim().equals("COMBI_FLAMER")
        || input.trim().equals("GRAV_GUN")
        || input.trim().equals("GRENADE_LAUNCHER")) {
      System.out.println(ColorText.ColorGREEN("weaponType получен"));
      return true;
    } else {
      System.out.println(ColorText.ColorRED("Некорректно введены данные") + ColorText.ColorYELLOW(" Попробуйте еще раз ввести weaponType:"));
      return false;
    }
  }
}
