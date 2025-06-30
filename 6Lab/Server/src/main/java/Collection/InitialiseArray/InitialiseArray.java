package Collection.InitialiseArray;

import Collection.InitialiseArray.FormatsDecoders.CsvToArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class InitialiseArray {

  Vector<String[]> DataStringArray;

  public InitialiseArray() {
    String pathToFile = System.getenv("CSV_FILE_PATH");
    try (
      InputStreamReader str = new InputStreamReader(new FileInputStream(pathToFile), "UTF-8");
      BufferedReader reader = new BufferedReader(str)) {
      this.DataStringArray = CsvToArray.readerToData(reader);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Ошибка при инициализации CollectionManager", e);
    }
  }

  public Vector<String[]> getArray() {
    return this.DataStringArray;
  }
  
}
