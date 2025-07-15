package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private Connection connection = null;
    // TODO:  Initialize the url string variable properly.  No need to load the
    //        JDBC URL, username, and password from a properties file.
    private final String url = "jdbc:mysql://localhost:3306/peertutor?useSSL=false&allowPublicKeyRetrieval=true";
    private String username = "root";
    private String password = "i*SH3xj#Ww45";

    public DataSource() {
    }

    /*
     * Only use one connection for this application, prevent memory leaks.
     */
    public Connection createConnection() {
        // TODO:  Add your code here.  Make sure to use try-catch statement.
        //        Make sure there is only one connection for this application
        //        to prevent memory leaks.
        // added use of Properties and try-with-resources - kriger
		try {
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
				connection = DriverManager.getConnection(url, username, password);
			}
		}
		catch(SQLException ex){
                    ex.printStackTrace();
		}
		return connection;
    }

}
