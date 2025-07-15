/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 /*
Student Name: Nouraldin Hassan
Student Number: 041054019
Course & Section #: 22S_CST8288_010/011
Declaration:
This is my own original work and is free from Plagiarism.
 */
package pkgDBManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class manages the database mainly named 'ontario'. Requires MySQL
 * TODO: Refactor into DAO pattern (transfer objects (recipients), see Stan Pieda DAO Example.
 * @author Nouraldin Hassan
 */
public class DatabaseManager {

    /**
     * the connection or session with a database.
     */
    protected Connection connection;

    /**
     * The main constructor for managing the database(s).
     */
    public DatabaseManager() {

        Properties props = new Properties();
        try ( //InputStream in = new FileInputStream("src/pkgDBManagerTest/database.properties");
                InputStream in = Files.newInputStream(Paths.get("src/pkgDBManager/database.properties"))) {
            props.load(in);

            String url = props.getProperty("jdbc.url");
            String user = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException /*| SQLException e*/ e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the recipients from the recipients table in the database
     *
     * @see displayNeatRecipientsTable() For the neater display method.
     */
    public void displayRecipientsTable() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipients");
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Column Type: " + metaData.getColumnTypeName(i));
                System.out.println("Java Class: " + metaData.getColumnClassName(i));
            }

            System.out.println("Recipients Data:");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(metaData.getColumnName(i) + ": " + resultSet.getString(i));
                }
                System.out.println();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays a neater presentation of the recipients from the recipients
     * table in the database <br>
     *
     * @see displayRecipientsTable() For the line-by-line display method.
     */
    public void displayNeatRecipientsTable() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipients");
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            int[] columnWidths = new int[columnCount];

            // Calculate column widths based on column names and data
            for (int i = 1; i <= columnCount; i++) {
                columnWidths[i - 1] = Math.max(metaData.getColumnName(i).length(), metaData.getColumnTypeName(i).length());
            }

            System.out.println("Recipients Data:");

            // Display column headers
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                System.out.print(String.format("%-2" + (columnWidths[i - 1] + 2) + "s", columnName));
            }
            System.out.println();

            // Display column data
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnData = resultSet.getString(i);
                    System.out.print(String.format("%-2" + (columnWidths[i - 1] + 2) + "s", columnData));
                }
                System.out.println();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a recipient to the recipients table in the database
     */
    public void insertRecipient(String name, int year, String city, String category) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO recipients (Name, Year, City, Category) VALUES (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setInt(2, year);
            statement.setString(3, city);
            statement.setString(4, category);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a recipient from the recipients table in the database
     */
    public void deleteRecipient(int recipientId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM recipients WHERE AwardID = ?");
            statement.setInt(1, recipientId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the connection from the database and this program. Useful for
     * de-allocating memory <br> <b>Very important to use at the end of
     * execution!</b>
     */
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
