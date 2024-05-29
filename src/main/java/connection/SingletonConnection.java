package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Single instance of the class and a single instance of the connection. 
public final class SingletonConnection {
	
	private static SingletonConnection instance;
	//The conn variable isn't declared as static, 
	//Not static to not be shared among all instances of the class. 
	private /*static*/ Connection conn;
	
	private static final String URL = "jdbc:mysql://localhost:3306/architecture";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	
    // Private constructor to prevent instantiation from outside of this class
    private SingletonConnection() {
    }
    
    
    public static SingletonConnection getInstance() throws SQLException {
        if (instance == null) {
            try {
            	
            	//step:1 for connection - load the driver class 
                Class.forName("com.mysql.jdbc.Driver");
                
                //step:2- create a connection
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                
                instance = new SingletonConnection();
                instance.conn = connection;
                System.out.println("Connected successfully");
                
            } catch (ClassNotFoundException | SQLException e) {
                //System.out.println(e.getMessage());
                e.printStackTrace(); // Handle the exception according to your needs
                throw new SQLException("Failed to establish a database connection.", e);
            }
        }
        return instance;
    }
    
    
    // Method to get Connection
    public Connection getConnection() {
        return conn;
    }

}
