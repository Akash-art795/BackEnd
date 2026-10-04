package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import studentFeedback.DBconnection;

public class Procedure {
	String procedure = 
			"create procedure updates(in ids int,in usernames varchar(50))"
			+"begin "
			+"update users set username=usernames where id = ids;"
			+"select * from users;"
			+"end";
	public void createProcedure() {
		Connection c = Dbconnection.dbconnection();
		try {
			Statement st = c.createStatement();
			boolean result = st.execute(procedure);
			System.out.println("Result: "+result);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String call = "{call inserts(?,?)}";
	public void callProcedure() {
		Connection c = Dbconnection.dbconnection();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter UserName: ");
		String name  = s.nextLine();
		System.out.println("Enter Date: ");
		String date = s.nextLine();
		
		try {
			CallableStatement cs = c.prepareCall(call);
			cs.setString(1, name);
			cs.setString(2, date);
			boolean result = cs.execute();
			if(result) {
				ResultSet rs = cs.getResultSet();
				while(rs.next()) {
					System.out.println("Name: "+rs.getString("username")+",Dates: "+ rs.getDate("dates"));
				}
			}
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String updateCall = "{call updates(?,?)}";
	public void updateProcedure() {
		Connection c = Dbconnection.dbconnection();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = s.nextLine();
		System.out.println("Enter Id:  ");
		int id = s.nextInt();
		
		try {
			CallableStatement cs = c.prepareCall(updateCall);
			cs.setInt(1, id);
			cs.setString(2,name);
			boolean result = cs.execute();
			if(result) {
				ResultSet rs = cs.getResultSet();
				while(rs.next()) {
					System.out.println("Name: "+rs.getString("username")+",Dates: "+ rs.getDate("dates"));
				}
			}
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String deletes = "DELETE FROM Student WHERE id = ?";

	public void Delete() {
	    Connection c = DBconnection.dbconnection();
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter your Id to Delete: ");
	    int id = s.nextInt();
	    try {
	        PreparedStatement ps = c.prepareStatement(deletes);
	        ps.setInt(1, id);
	        int result = ps.executeUpdate();
	        if (result > 0) {
	            System.out.println("Student deleted successfully");
	        } else {
	            System.out.println("Student ID not found");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
}
