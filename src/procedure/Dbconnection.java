package procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	private static String url = "jdbc:mysql://localhost:3306/procedures";
	private static String userName = "root";
	private static String passWord = "123456";
	
	public static Connection dbconnection() {
		Connection c = null;
		try {
			c =  DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return c;
	}
}

