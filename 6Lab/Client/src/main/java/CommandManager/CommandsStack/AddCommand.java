package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.CheckValidCommandData.*;
import NetworkPackage.NetworkRequestaGenericPackage;
import java.util.Scanner;

public class AddCommand implements Command {
  @Override
  public String getName() {
    return "add";
  }

  @Override
  public NetworkRequestaGenericPackage execute(
      String line, CommandManager commandManager, Scanner scanner) {
    String name = "-";
    String coordinates = "-";
    String health = "-";
    String loyal = "-";
    String achievements = "-";
    String weaponType = "-";
    String chapter = "-";

    boolean flag = true;

    if (line.trim().equals("add")) {

      System.out.println(ColorText.ColorYELLOW("Введите name для нового элемента:"));
      int i_count = -1;
      while (true) {
        if ((i_count != -1) && (i_count < 7)) {

          String input = scanner.nextLine();
          if (input.equals("/stop")) {
            System.out.println("Процесс ввода данных для команды add прерван");
            flag = false;
            break;
          }

          if (i_count == 0) {
            if (NameCheck.nameCheck(input)) {
              System.out.println(
                  ColorText.ColorYELLOW("Теперь введите coordinates: (пример 3_4.5)"));
              name = input;
              ++i_count;
              continue;
            }
          }

          if (i_count == 1) {
            if (CoordinatesCheck.coordinatesCheck(input)) {
              System.out.println(
                  ColorText.ColorYELLOW("Теперь введите health: (пример 4.3, health > 0)"));
              coordinates = "{" + input.replace("_", ";") + "}";
              ++i_count;
              continue;
            }
          }

          if (i_count == 2) {
            if (HealthCheck.healthCheck(input)) {
              System.out.println(
                  ColorText.ColorYELLOW("Теперь введите loyal: (пример: true или false)"));
              if (input.trim().equals("")) {
                health = "null";
              } else {
                health = input;
              }
              ++i_count;
              continue;
            }
          }

          if (i_count == 3) {
            if (LoyalCheck.loyalCheck(input)) {
              System.out.println(ColorText.ColorYELLOW("Теперь введите achievements:"));
              loyal = input;
              ++i_count;
              continue;
            }
          }

          if (i_count == 4) {
            if (AchievementsCheck.achievementsCheck(input)) {
              System.out.println(
                  ColorText.ColorYELLOW(
                      "Теперь введите weaponType: (Варианты: BOLTGUN, COMBI_FLAMER, GRAV_GUN, GRENADE_LAUNCHER)"));
              achievements = input;
              ++i_count;
              continue;
            }
          }

          if (i_count == 5) {
            if (WeaponTypeCheck.weaponTypeCheck(input)) {
              System.out.println(
                  ColorText.ColorYELLOW("Теперь введите chapter: (пример: earth_russia)"));
              weaponType = input;
              ++i_count;
              continue;
            }
          }

          if (i_count == 6) {
            if (ChapterCheck.chapterCheck(input)) {
              chapter = "{" + input.replace("_", ";") + "}";
              ++i_count;
              continue;
            }
          }

        } else if (i_count == -1) {
          ++i_count;
          continue;
        } else {
          break;
        }
      }

    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда add"));
    }
    NetworkRequestaGenericPackage packData = new NetworkRequestaGenericPackage("add", flag);
    if (flag) {
      packData.getMainData("-", name, coordinates, health, loyal, achievements, weaponType, chapter);
    }
    return packData;
  }
}
