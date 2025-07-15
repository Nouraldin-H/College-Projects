package displayauthors;

//Original by Deitel & Deitel
//additional code by kriger
// Fig. 28.23: DisplayAuthors.java
// Displaying the contents of the authors table.
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    // launch the application
    public static void main(String args[]) {

        Properties props = new Properties();
        // try-with-resources
        try ( InputStream in = Files.newInputStream(Paths.get("src/database.properties"));
            ) {

            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        
        // connect to database books and query database
        // try-with-resources
        try (
                // establish connection to database                              
                 Connection connection = DriverManager.getConnection(
                        url, username, password); // create Statement for querying database
                  Statement statement = connection.createStatement(); // query database                                        
                  ResultSet resultSet = statement.executeQuery("SELECT AuthorID, FirstName, LastName FROM authors");
            ) {

            // process query results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors Table of Books Database:\n");

            //columns start at 1 NOT zero !! - GJK     
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            } // end while
            System.out.println("\nAuthors Table - Column Attributes:");

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch                                                     

    } // end main
} // end class DisplayAuthors

/**
 * ************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 ************************************************************************
 */
