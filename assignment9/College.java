package assignment9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class College {
	Scanner s = new Scanner(System.in);
	Connection c = DBconnection.db();
	static String student = "CREATE TABLE STUDENT("
			+ "ID INT PRIMARY KEY,"
			+ "NAME VARCHAR(50),"
			+ "AGE INT,"
			+ "COURSE VARCHAR(20)"
			+ ");";
	public void create() {
		
		try {
			Statement st = c.createStatement();
			st.execute(student);
			System.out.println("Table Created");
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	static String insert = "INSERT INTO STUDENT(ID,NAME,AGE,COURSE)"
			+ "VALUE(?,?,?,?);";
	public void inserts() {
		System.out.println("Enter id: ");
		int ID = s.nextInt();
		s.nextLine();
		System.out.println("Enter Name: ");
		String NAME = s.nextLine();
		System.out.println("Enter Age: ");
		int AGE = s.nextInt();
		s.nextLine();
		System.out.println("Enter Course: ");
		String COURSE = s.nextLine();
		try {
			PreparedStatement p = c.prepareStatement(insert);
			p.setInt(1, ID);
			p.setString(2, NAME);
			p.setInt(3, AGE);
			p.setString(4, COURSE);
			p.executeUpdate();
			System.out.println("STUDENT INSERTED SUCCESSFULLY...");
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String select = "select * from Student";
	public void display() {
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				System.out.println("NAME: "+rs.getString("NAME")+"\n"+"AGE: "+rs.getString("AGE")+" "+"COURSE: "+rs.getString("COURSE")+" "+"ID: : "+rs.getLong("ID"));
			}
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
