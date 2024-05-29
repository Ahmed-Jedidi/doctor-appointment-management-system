package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException {
		SingletonConnection singleton = SingletonConnection.getInstance();
		
		Connection connection = singleton.getConnection();
	}

}
