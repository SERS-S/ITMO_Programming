package ProcessCore.ProcessCommandModule;

import Collection.CollectionManager;
import NetworkPackage.NetworkRequestGenericPackage;
import NetworkPackage.NetworkResponceGenericPackage;
import ProcessCore.DataBaseManagerModule.DataBaseConnection;
import ProcessCore.DataBaseManagerModule.StatementConnection;
import ProcessCore.ProcessCommandModule.CommandManager.CommandManager;
import ProcessCore.ProcessCommandModule.CommandManager.CommandsStack.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProcessCommand {

  protected String packageMode;

  protected boolean validAutharizationRegistration;

  protected String commandName;
  protected Boolean correctCommand;

  protected ArrayList<String> responceStrings;

  public ProcessCommand(CollectionManager collectionManager, NetworkRequestGenericPackage packOne) {

    this.packageMode = packOne.getPackageMode();

    if (packOne.getPackageMode().equals("dataPackage")) {

      CommandManager commandManager = new CommandManager();

      for (Command cmd : commandManager.getCommandsList()) {
        if (packOne.getCommandName().contains(cmd.getName())) {

          this.commandName = packOne.getCommandName();
          this.correctCommand = packOne.getCorrectedInputData();

          if (packOne.getCorrectedInputData()) {

            DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "5432", "studs");
            StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());
            try {
              statementConnection.addNewActivityMonitorNotice(UUID.randomUUID().toString(), packOne.getClientUser().getLogin(), commandName);
            } catch (RuntimeException e) {
              e.printStackTrace();
            }

            responceStrings = cmd.execute(collectionManager, packOne, commandManager);
          }

          break;
        }
      }

    } else if (packOne.getPackageMode().equals("identificationPackage")) {

      DataBaseConnection dataBaseConnection = new DataBaseConnection("db", "5432", "studs");
      StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());

      if (packOne.getAuthorizationRegistrationMode().equals("authorization")) {
        System.out.println("# authorization");

        try {
          statementConnection.addNewActivityMonitorNotice(UUID.randomUUID().toString(), packOne.getClientUser().getLogin(), "auth");
        } catch (RuntimeException e) {
          e.printStackTrace();
        }
        
        String checkAuthStatus = statementConnection.checkAuthorization(packOne.getClientUser().getLogin(), packOne.getClientUser().getPassword());
        switch (checkAuthStatus) {

          case "NotExist":
            responceStrings = new ArrayList<String>(List.of("RED#" + "Пользователя с данным логином не существует"));
            validAutharizationRegistration = false;
            System.out.println("NotExist");
            break;

          case "IncorrectPassword":
            responceStrings = new ArrayList<String>(List.of("RED#" + "Неврный пароль для пользователя с логином: " + packOne.getClientUser().getLogin()));
            validAutharizationRegistration = false;
            System.out.println("IncorrectPassword");
            break;

          case "FullCorrectLogPass":
            responceStrings = new ArrayList<String>(List.of("GREEN#" + "Вход в аккуунт с логином: " + packOne.getClientUser().getLogin() + " выполнен успешно"));
            validAutharizationRegistration = true;
            System.out.println("FullCorrectLogPass");
            break;

          case "SQLError":
            responceStrings = new ArrayList<String>(List.of("RED#" + "Ошибка SQL запроса"));
            validAutharizationRegistration = false;
            System.out.println("SQLError");
            break;

        }
        
      } else if (packOne.getAuthorizationRegistrationMode().equals("registration")) {
        System.out.println("# registration");

        String checkRegistrStatus = statementConnection.completeRegistration(packOne.getClientUser().getLogin(), packOne.getClientUser().getPassword());

        switch (checkRegistrStatus) {
          case "UserAlreadyExist":
            responceStrings = new ArrayList<String>(List.of("RED#" + "Пользователь с таким логином уже существует"));
            validAutharizationRegistration = false;
            break;

          case "RegistrationComplete":
            responceStrings = new ArrayList<String>(List.of("GREEN#" + "Регистрация пользователя с логином: " + packOne.getClientUser().getLogin() + " выполнена успешно"));
            validAutharizationRegistration = true;

            try {
              statementConnection.addNewActivityMonitorNotice(UUID.randomUUID().toString(), packOne.getClientUser().getLogin(), "registr");
            } catch (RuntimeException e) {
              e.printStackTrace();
            }
            
            break;

          case "SQLError":
            responceStrings = new ArrayList<String>(List.of("RED#" + "Ошибка SQL запроса"));
            validAutharizationRegistration = false;
            break;
        }

        for (String str : responceStrings) {
          System.out.println(str);
        }
      }

    }

  }

  public NetworkResponceGenericPackage getNetworkResponcePack() {

    if (packageMode.equals("identificationPackage")) {
      NetworkResponceGenericPackage networkResponceGenericPackage = new NetworkResponceGenericPackage("identificationPackage", validAutharizationRegistration);
      networkResponceGenericPackage.getResponceData(responceStrings);
      return networkResponceGenericPackage;
    } else {
      NetworkResponceGenericPackage networkResponceGenericPackage = new NetworkResponceGenericPackage("dataPackage", commandName, correctCommand);
      networkResponceGenericPackage.getResponceData(responceStrings);
      return networkResponceGenericPackage;
    }

  }

}
