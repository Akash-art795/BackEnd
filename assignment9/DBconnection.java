package assignment9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static String url = "jdbc:mysql://localhost:3306/Product_db";
	private static String name = "root";
	private static String password = "123456";
	
	public static Connection db() {
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return c;
	}
}
