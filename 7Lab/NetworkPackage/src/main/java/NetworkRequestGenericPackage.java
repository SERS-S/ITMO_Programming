package NetworkPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class NetworkRequestGenericPackage implements Serializable {

  private static final long serialVersionUID = 1L;

  public static class ClientUser implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String login;
    protected String password;

    public ClientUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
  }

  protected String packageMode; // identificationPackage | dataPackage
  protected String AuthorizationRegistrationMode; // authorization | registration
  protected ClientUser clientUser;

  protected String CommandName;
  protected boolean CorrectedInputData;

  protected String id;
  protected String name;
  protected String coordinates;
  protected String health;
  protected String loyal;
  protected String achievements;
  protected String weaponType;
  protected String chapter;

  protected ArrayList<String> scriptLines;

  public NetworkRequestGenericPackage(String packageMode, String AuthorizationRegistrationMode, String login, String password) {
    this.packageMode = packageMode;
    this.AuthorizationRegistrationMode = AuthorizationRegistrationMode;
    this.clientUser = new ClientUser(login, password);
  }

  public NetworkRequestGenericPackage(String packageMode, String CommandName, boolean CorrectedInputData) {
    this.packageMode = packageMode;
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

  public void setClientUser(String login, String password) {
    this.clientUser = new ClientUser(login, password);
  }

  public String getPackageMode() {
    return packageMode;
  }

  public String getAuthorizationRegistrationMode() {
    return AuthorizationRegistrationMode;
  }

  public ClientUser getClientUser() {
    return clientUser;
  }

  public String getCommandName() {
    return CommandName;
  }

  public boolean getCorrectedInputData() {
    return CorrectedInputData;
  }

  public String[] getDataStrings() {
    return new String[] {id, name, coordinates, health, loyal, achievements, weaponType, chapter};
  }

  public ArrayList<String> getScriptLines() {
    return scriptLines;
  }
}
