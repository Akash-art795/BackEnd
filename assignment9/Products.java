package assignment9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Products {
	Connection c =  DBconnection.db();
	Scanner s = new Scanner(System.in);
	
	private String product = "CREATE TABLE PRODUCT("
			+ "PRODUCT_ID INT PRIMARY KEY AUTO_INCREMENT,"
			+ "PRODUCT_NAME VARCHAR(50),"
			+ "PRICE DOUBLE,"
			+ "QUANTITY INT"
			+ ");";
	public void create() {
		try {
			Statement st = c.createStatement();
			st.execute(product);
			System.out.println("Table Created");
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	private String insert = "INSERT INTO PRODUCT(PRODUCT_NAME,PRICE,QUANTITY)"
			+ "VALUE(?,?,?)";
	public void inserts() {
		System.out.println("Enter Product Name: ");
		String name = s.nextLine();
		System.out.println("Enter Price: ");
		int price = s.nextInt();
		s.nextLine();
		System.out.println("Enter Quantity: ");
		int quantity = s.nextInt();
		s.nextLine();
		try {
			PreparedStatement p = c.prepareStatement(insert);
			p.setString(1, name);
			p.setInt(2, price);
			p.setInt(3, quantity);
			p.executeUpdate();
			System.out.println("Product added Successfully");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	private String show = "SELECT * FROM PRODUCT"; 
	public void display() {
		try {
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(show);
			
			while(r.next()) {
				System.out.println("ID: "+r.getInt(1));
				System.out.println("NAME: "+r.getString(2));
				System.out.println("PRICE: "+r.getInt(3));
				System.out.println("QUANTITY: "+r.getInt(4));
				System.out.println("---------------------------");
			}
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	

}
