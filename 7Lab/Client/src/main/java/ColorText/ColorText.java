package ColorText;

/** Класс раскрасок текста ColorText */
public class ColorText {
  public static final String RESET = "\u001B[0m"; // Сброс цвета
  public static final String RED = "\u001B[31m"; // Красный
  public static final String GREEN = "\u001B[32m"; // Зелёный
  public static final String YELLOW = "\u001B[33m"; // Жёлтый
  public static final String BLUE = "\u001B[34m"; // Синий
  public static final String PURPLE = "\u001B[35m"; // Фиолетовый
  public static final String CYAN = "\u001B[36m"; // Голубой
  public static final String WHITE = "\u001B[37m"; // Белый

  public static String ColorRED(String text) {
    return (RED + text + RESET);
  }

  public static String ColorGREEN(String text) {
    return (GREEN + text + RESET);
  }

  public static String ColorYELLOW(String text) {
    return (YELLOW + text + RESET);
  }

  public static String ColorBLUE(String text) {
    return (BLUE + text + RESET);
  }

  public static String ColorPURPLE(String text) {
    return (PURPLE + text + RESET);
  }

  public static String ColorCYAN(String text) {
    return (CYAN + text + RESET);
  }

  public static String ColorWHITE(String text) {
    return (WHITE + text + RESET);
  }
}
