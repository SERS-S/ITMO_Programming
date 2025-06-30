package CommandManager.CommandsStack;

import ColorText.ColorText;
import CommandManager.CommandManager;
import CommandManager.CommandsStack.CheckValidCommandData.*;
import NetworkPackage.NetworkRequestGenericPackage;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateCommand implements Command {
  @Override
  public String getName() {
    return "update";
  }

  @Override
  public NetworkRequestGenericPackage execute(String line, CommandManager commandManager, Scanner scanner) {
    
    boolean flag = true;
    String name = "-";
    String coordinates = "-";
    String health = "-";
    String loyal = "-";
    String achievements = "-";
    String weaponType = "-";
    String chapter = "-";

    if ((line.split(" ").length == 3) && (line.split(" ")[0].equals("update"))) {
      System.out.println(line.split(" ")[0] + " " + line.split(" ")[1] + " " + line.split(" ")[2]);
      if (Arrays.asList("name", "coordinates", "health", "loyal", "achievements", "weaponType", "chapter").contains(line.split(" ")[2].trim())) {
        System.out.println("  > " + ColorText.ColorGREEN("Введите новое значение поля ") + line.split(" ")[2].trim() + ColorText.ColorGREEN(" элемента:"));

        int i_count = -1;
        while (true) {
          if (i_count != -1) {
            String input = scanner.nextLine();
            if (input.equals("/stop")) {
              System.out.println("Процесс ввода данных для команды update прерван");
              flag = false;
              break;
            }

            if (line.split(" ")[2].trim().equals("name")) {
              if (NameCheck.nameCheck(input)) {
                name = input;
                break;
              }
            }

            if (line.split(" ")[2].trim().equals("coordinates")) {
              if (CoordinatesCheck.coordinatesCheck(input)) {
                coordinates = input;
                break;
              }
            }

            if (line.split(" ")[2].trim().equals("health")) {
              if (HealthCheck.healthCheck(input)) {
                if (input.trim().equals("")) {
                  health = "null";
                } else {
                  health = input;
                }
                break;
              }
            }

            if (line.split(" ")[2].trim().equals("loyal")) {
              if (LoyalCheck.loyalCheck(input)) {
                loyal = input;
                break;
              }
            }

            if (line.split(" ")[2].trim().equals("achievements")) {
              if (AchievementsCheck.achievementsCheck(input)) {
                achievements = input;
                break;
              }
            }

            if (line.split(" ")[2].trim().equals("weaponType")) {
              if (WeaponTypeCheck.weaponTypeCheck(input)) {
                weaponType = input;
                break;
              }
            }

            if (line.split(" ")[2].trim().equals("chapter")) {
              if (ChapterCheck.chapterCheck(input)) {
                chapter = input;
                break;
              }
            }
          } else if (i_count == -1) {
            ++i_count;
            continue;
          }
        }
      } else {
        flag = false;
        System.out.println(ColorText.ColorRED(ColorText.ColorRED("Некорректно введенные данные!")));
      }

    } else {
      flag = false;
      System.out.println(ColorText.ColorRED("некорректна введена команда update"));
    }
    NetworkRequestGenericPackage packData = new NetworkRequestGenericPackage("dataPackage", "update", flag);
    if (flag) {
      packData.getMainData(line.split(" ")[1], name, coordinates, health, loyal, achievements, weaponType, chapter);
    }
    return packData;
  }
}
