package NetworkPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class NetworkRequestaGenericPackage implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String CommandName;
  protected Boolean CorrectedInputData;

  protected String id;
  protected String name;
  protected String coordinates;
  protected String health;
  protected String loyal;
  protected String achievements;
  protected String weaponType;
  protected String chapter;

  protected ArrayList<String> scriptLines;

  public NetworkRequestaGenericPackage(String CommandName, Boolean CorrectedInputData) {
    this.CommandName = CommandName;
    this.CorrectedInputData = CorrectedInputData;
  }

  public void getMainData(String id, String name, String coordinates, String health, String loyal, String achievements, String weaponType, String chapter) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.health = health;
    this.loyal = loyal;
    this.achievements = achievements;
    this.weaponType = weaponType;
    this.chapter = chapter;
  }

  public void getScriptData(ArrayList<String> scriptLines) {
    this.scriptLines = scriptLines;
  }

  public String getCommandName() {
    return CommandName;
  }

  public Boolean getCorrectedInputData() {
    return CorrectedInputData;
  }

  public String[] getDataStrings() {
    return new String[] {id, name, coordinates, health, loyal, achievements, weaponType, chapter};
  }

  public ArrayList<String> getScriptLines() {
    return scriptLines;
  }
}
