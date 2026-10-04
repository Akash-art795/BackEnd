package studentFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentFeedbackLogics {
	Scanner s = new Scanner(System.in);
	static String student = "create table Student("
			+"id int primary key auto_increment,"
			+"SName varchar(50),"
			+"Dates date,"
			+"FeedBack text,"
			+"Phno bigint"+")";
	public static void create() {
		Connection c = DBconnection.dbconnection();
		try {
			Statement st = c.createStatement();
			st.executeUpdate(student); //used when we make changes in Database
			
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	static String insert = "insert into Student(SName,Dates,FeedBack,phno)"
			+ "value(?,?,?,?);";
	public void insert1() {
		
		System.out.print("Enter Student Name: ");
		String SName = s.nextLine();
		System.out.print("Enter Date: ");
		String Dates = s.nextLine();
		System.out.print("Give Your FeedBack: ");
		String FeedBack = s.nextLine();
		System.out.print("Enter Your Phone Number: ");
		long phno = s.nextLong();
		Connection con = DBconnection.dbconnection();
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, SName);
			ps.setString(2, Dates);
			ps.setString(3, FeedBack);
			ps.setLong(4, phno);
			
			int row = ps.executeUpdate();
			if(row>0) {
				System.out.println("Data Stored");
			}
			else {
				System.out.println("Data Not Stored");
			}
		} catch (SQLException e) {
			System.out.println("Insertion Error: "+e.getMessage());
		}
	}
	String select = "select * from Student";
	public void display() {
		Connection c = DBconnection.dbconnection();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				System.out.println("SName: "+rs.getString("SName")+"\n"+"Dates:"+rs.getString("Dates")+" "+"FeedBack: "+rs.getString("FeedBack")+" "+"Phone-No: "+rs.getLong("phno"));
			}
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	String update = "update Student set SName=?,Dates=?,Feedback=?,phno=? where id = ?";
	public void Update() {
		Connection c = DBconnection.dbconnection();
		System.out.print("Enter your Id: ");
		int id = s.nextInt();
		s.nextLine();
		System.out.print("enter Your Name: ");
		String sname = s.nextLine();
		System.out.print("enter Dates: ");
		String Dates = s.nextLine();
		System.out.print("Enter Your FeedBack: ");
		String Feedback = s.nextLine();
		System.out.print("Enter Your Phno: ");
		Long phone = s.nextLong();
		try {
			PreparedStatement ps = c.prepareStatement(update);
			
			ps.setString(1, sname);
			ps.setString(2, Dates);
			ps.setString(3, Feedback);
			ps.setLong(4, phone);
			ps.setInt(5, id);
			int row = ps.executeUpdate();
			if(row == 1) {
				System.out.println("id updated");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		finally {
			System.out.println("Function working");
		}
	}
	String delete = "delete from Student where id =?";
	public void Delete() {
		Connection c = DBconnection.dbconnection();
		System.out.println("Enter your Id to Delete: ");
		int id = s.nextInt();
		try {
			PreparedStatement ps = c.prepareStatement(delete);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row==1) {
				System.out.println("Deleted Successfully");
			}
			
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
