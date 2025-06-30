package ColorText;

import java.util.ArrayList;

public class ColorResponce {

  public static void ColorOutputText(ArrayList<String> text) {
    for (String str : text) {
      String[] words = str.split("#");
      switch (words[0]) {
        case "RED":
          System.out.println(ColorText.ColorRED(words[1]));
          break;
        case "GREEN":
          System.out.println(ColorText.ColorGREEN(words[1]));
          break;
        case "BLUE":
          System.out.println(ColorText.ColorBLUE(words[1]));
          break;
        case "PURPLE":
          System.out.println(ColorText.ColorPURPLE(words[1]));
          break;
        case "CYAN":
          System.out.println(ColorText.ColorCYAN(words[1]));
          break;
        case "YELLOW":
          System.out.println(ColorText.ColorYELLOW(words[1]));
          break;
        case "WHITE":
          System.out.println(ColorText.ColorWHITE(words[1]));
          break;
        default:
          System.out.println(str);
          break;
      }
    }
  }
}
