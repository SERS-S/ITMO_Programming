package Collection.InitialiseArray;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;

import ProcessCore.DataBaseManagerModule.DataBaseConnection;
import ProcessCore.DataBaseManagerModule.StatementConnection;

public class InitialiseArray {

  Vector<String[]> dataStringArray;

  public InitialiseArray() {
    DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "5432", "studs");
    StatementConnection statementConnection = new StatementConnection(dataBaseConnection.getConnection());

    dataStringArray = statementConnection.getCollectionData();
  }

  public Vector<String[]> getArray() {
    return this.dataStringArray;
  }
  
}
