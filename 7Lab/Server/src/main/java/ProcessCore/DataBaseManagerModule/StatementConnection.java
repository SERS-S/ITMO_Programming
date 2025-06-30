package ProcessCore.DataBaseManagerModule;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Vector;

public class StatementConnection {
    
    Connection connection;

    public static String sha384Hashing(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String h = Integer.toHexString(0xff & b);
                if (h.length() == 1) hex.append('0');
                hex.append(h);
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-384 algorithm not available", e);
        }
    }

    public StatementConnection(Connection connection) {
        this.connection = connection;
    }

    public String checkAuthorization(String login, String password) {
        String sqlLoginStatement = "SELECT id FROM Users WHERE login = ?;";
        try (PreparedStatement psLogin = connection.prepareStatement(sqlLoginStatement)) {
            psLogin.setString(1, login);

            try (ResultSet resultLoginQuery = psLogin.executeQuery()) {
                if (resultLoginQuery.next()) {
                    String sqlPasswordStatement = "SELECT * FROM Users WHERE login = ? AND password = ?;";
                    try (PreparedStatement psPassword = connection.prepareStatement(sqlPasswordStatement)) {
                        psPassword.setString(1, login);
                        psPassword.setString(2, sha384Hashing(password));

                        try (ResultSet resultPasswordQuery = psPassword.executeQuery()) {
                            if (resultPasswordQuery.next()) {
                                return "FullCorrectLogPass";
                            } else {
                                return "IncorrectPassword";
                            }
                        } catch (SQLException e) {
                            return "SQLError";
                        }
                    }
                } else {
                    return "NotExist";
                }
            }

        } catch (SQLException e) {
            return "SQLError";
        }

    }

    public String completeRegistration(String login, String password) {
        String sqlLoginRequest = "SELECT id FROM Users WHERE login = ?;";
        try (PreparedStatement psLogin = connection.prepareStatement(sqlLoginRequest)) {
            psLogin.setString(1, login);

            try (ResultSet resultLoginQuery = psLogin.executeQuery()) {
                if (resultLoginQuery.next()) {
                    return "UserAlreadyExist";
                } else {
                    String sqlInsertStatement = "INSERT INTO Users (id, login, password) VALUES (nextval('generateUserId'), ?, ?);";
                    try (PreparedStatement psInsert = connection.prepareStatement(sqlInsertStatement)) {
                        psInsert.setString(1, login);
                        psInsert.setString(2, sha384Hashing(password));
                        psInsert.executeUpdate();
                        return "RegistrationComplete";
                    }
                }
            }

        } catch (SQLException e) {
            return "SQLError";
        }

    }

    public Vector<String[]> getCollectionData() {
        String sqlCollectionStatement = "SELECT * FROM Collection;";
        try (PreparedStatement psCollectionData = connection.prepareStatement(sqlCollectionStatement)) {
            try (ResultSet collectionQuery = psCollectionData.executeQuery()) {

                Vector<String[]> dataStringArray = new Vector<>();
                while (collectionQuery.next()) {
                    String[] dataString = new String[10];
                    dataString[0] = collectionQuery.getString("id");
                    dataString[1] = collectionQuery.getString("name");
                    dataString[2] = collectionQuery.getString("coordinates");
                    dataString[3] = collectionQuery.getString("creationDate");
                    if (collectionQuery.getString("health") != null) {
                        dataString[4] = collectionQuery.getString("health");
                    } else {
                        dataString[4] = "null";
                    }
                    dataString[5] = collectionQuery.getString("loyal");
                    dataString[6] = collectionQuery.getString("achievements");
                    dataString[7] = collectionQuery.getString("weaponType");
                    dataString[8] = collectionQuery.getString("chapters");
                    dataString[9] = collectionQuery.getString("createByUserLogin");
                    dataStringArray.add(dataString);
                }

                return dataStringArray;
                } catch (Exception e) {
                    System.out.println("Ошибка при инициализации массива: " + e.getMessage());
                    return new Vector<String[]>();
                }
        } catch (SQLException e) {
            e.printStackTrace();
            return new Vector<String[]>();
        }
    }

    public void addNewElement(String id, String name, String coordinates, Timestamp creationDate, String health, String loyal, String achievements, String weaponType, String chapter, String createByUserLogin) {
        // System.out.println("id: " + id + ", name: " + name + ", coordinates: " + coordinates + ", health: " + health + ", loyal: " + loyal + ", achievements: " + achievements + ", weaponType: " + weaponType + ", chapter: " + chapter + ", createByUserLogin: " + createByUserLogin);
        String sqlInsertNewElementString = "INSERT INTO Collection (id, name, coordinates, creationDate, health, loyal, achievements, weaponType, chapters, createByUserLogin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement psInsertNewElement = connection.prepareStatement(sqlInsertNewElementString)) {
            psInsertNewElement.setLong(1, Long.parseLong(id));
            psInsertNewElement.setString(2, name);
            psInsertNewElement.setObject(3, coordinates, java.sql.Types.OTHER);
            psInsertNewElement.setTimestamp(4, creationDate);
            if (health.equals("null")) {
                psInsertNewElement.setNull(5, java.sql.Types.FLOAT);
            } else {
                psInsertNewElement.setFloat(5, Float.parseFloat(health));
            }
            psInsertNewElement.setBoolean(6, Boolean.parseBoolean(loyal));
            psInsertNewElement.setString(7, achievements);
            psInsertNewElement.setString(8, weaponType);
            psInsertNewElement.setObject(9, chapter, java.sql.Types.OTHER);
            psInsertNewElement.setString(10, createByUserLogin);

            psInsertNewElement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при добавлении нового элемента в БД: " + e.getMessage());
        }
    }

    public void addNewActivityMonitorNotice(String uuidCode, String login, String typeCommand) {
        String sqlInsertNewActivityMonitorString = "INSERT INTO ActivityMonitor (id, login, typeCommand) VALUES (?, ?, ?);";
        try (PreparedStatement psInsertNewActivityMonito = connection.prepareStatement(sqlInsertNewActivityMonitorString)) {
            psInsertNewActivityMonito.setString(1, uuidCode);
            psInsertNewActivityMonito.setString(2, login);
            psInsertNewActivityMonito.setString(3, typeCommand);
            psInsertNewActivityMonito.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при добавлении сведений о новом запросе!");
        }
    }

    public void truncateCollection(String login) {
        String sqlTruncateStatement = "DELETE FROM Collection WHERE createByUserLogin = ?;";
        try (PreparedStatement psTruncate = connection.prepareStatement(sqlTruncateStatement)) {
            psTruncate.setString(1, login);
            psTruncate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при очистке коллекции: " + e.getMessage());
        }
    }

    public void removeByIdEelement(String id) {
        String sqlRemoveByIdString = "DELETE FROM Collection WHERE id = ?;";
        try (PreparedStatement psRemoveById = connection.prepareStatement(sqlRemoveByIdString)) {
            psRemoveById.setLong(1, Long.parseLong(id));
            psRemoveById.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при удалении элемента из БД: " + e.getMessage());
        }
    }

    public void updateCollectionElement(String id, String editField, String editValue) {
        String sqlUpdateString = "UPDATE Collection SET " + editField + " = ? WHERE id = ?;";
        try (PreparedStatement psUpdateElement = connection.prepareStatement(sqlUpdateString)) {
            psUpdateElement.setString(1, editValue);
            psUpdateElement.setLong(2, Long.parseLong(id));
            psUpdateElement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при обновлении элемента в БД: " + e.getMessage());
        }
    }

}
