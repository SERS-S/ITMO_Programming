package NetworkPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class NetworkResponceGenericPackage implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String commandName;
  protected Boolean correctCommand;

  protected ArrayList<String> responceStrings;

  public NetworkResponceGenericPackage(String commandName, Boolean correctCommand) {
    this.commandName = commandName;
    this.correctCommand = correctCommand;
  }

  public void getResponceData(ArrayList<String> responceStrings) {
    this.responceStrings = responceStrings;
  }

  public String getCommandName() {
    return commandName;
  }

  public Boolean getCorrectCommand() {
    return correctCommand;
  }

  public ArrayList<String> getResponceStrings() {
    return responceStrings;
  }
}
