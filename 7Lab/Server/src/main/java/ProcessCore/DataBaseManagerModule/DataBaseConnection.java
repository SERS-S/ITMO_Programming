package ProcessCore.DataBaseManagerModule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

    protected String host;
    protected String port;
    protected String scheme;

    protected Connection connection;

    public DataBaseConnection(String host, String port, String scheme) {
        this.host = host;
        this.port = port;
        this.scheme = scheme;
        initializationConnection();
    }

    public void initializationConnection() {
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + scheme;
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.cfg")) {

            Properties info = new Properties();
            info.load(in);

            try {
                this.connection = DriverManager.getConnection(url, info);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл db.cfg не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла db.cfg");
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
}
