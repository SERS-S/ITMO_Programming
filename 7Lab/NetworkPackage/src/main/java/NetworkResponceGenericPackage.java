package NetworkPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class NetworkResponceGenericPackage implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String packageMode; // identificationPackage | dataPackage

  protected boolean validAutharizationRegistration;

  protected String commandName;
  protected boolean correctCommand;

  protected ArrayList<String> responceStrings;

  public NetworkResponceGenericPackage(String packageMode, boolean validAutharizationRegistration) {
    this.packageMode = packageMode;
    this.validAutharizationRegistration = validAutharizationRegistration;
  }

  public NetworkResponceGenericPackage(String packageMode, String commandName, boolean correctCommand) {
    this.packageMode = packageMode;
    this.commandName = commandName;
    this.correctCommand = correctCommand;
  }

  public void getResponceData(ArrayList<String> responceStrings) {
    this.responceStrings = responceStrings;
  }

  public String getCommandName() {
    return commandName;
  }

  public String getPackageMode() {
    return packageMode;
  }

  public boolean getValidAutharizationRegistration() {
    return validAutharizationRegistration;
  }

  public boolean getCorrectCommand() {
    return correctCommand;
  }

  public ArrayList<String> getResponceStrings() {
    return responceStrings;
  }
}
