package assignment9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	Scanner s = new Scanner(System.in);
	Connection c = DBconnection.db();
	static String employee = "CREATE TABLE EMPLOYEE("
			+ "EMP_ID INT PRIMARY KEY AUTO_INCREMENT,"
			+ "EMP_NAME VARCHAR(50),"
			+ "SALARY DOUBLE,"
			+ "DEPARTMENT VARCHAR(50)"
			+ ");";
	public void create() {
		try {
			Statement st = c.createStatement();
			st.execute(employee);
			System.out.println("Table Created");
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String inserts = "INSERT INTO EMPLOYEE(EMP_NAME,SALARY,DEPARTMENT)"
			+ "VALUES(?,?,?);";
	public void inserts() {
		try {
			System.out.println("Enter Name: ");
			String name = s.nextLine();
			System.out.println("Enter Salary: ");
			Double salary = s.nextDouble();
			s.nextLine();
			System.out.println("Enter Department: ");
			String department = s.nextLine();
			PreparedStatement p = c.prepareStatement(inserts);
			p.setString(1, name);
			p.setDouble(2, salary);
			p.setString(3, department);
			p.executeUpdate();
			System.out.println("Data Added SUccessfully....");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String show = "SELECT * FROM EMPLOYEE";
	public void display() {
		try {
			Statement s = c.createStatement();
			ResultSet r =  s.executeQuery(show);
			
			while(r.next()) {
				System.out.println("ID: "+r.getInt(1));
				System.out.println("EMP_NAME: "+r.getString(2));
				System.out.println("SALARY: "+r.getDouble(3));
				System.out.println("Department: "+r.getString(4));
				System.out.println("----------------------22");
			}
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
