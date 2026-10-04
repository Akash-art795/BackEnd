package studentFeedback;

import java.util.Scanner;

public class StudentFeedback {
	public static void main(String[] args) {
		//System.out.println(DBconnection.dbconnection());
		
		//StudentFeedbackLogics.create();
		
		StudentFeedbackLogics store = new StudentFeedbackLogics();
//		store.insert1();
//		store.insert1();
		//store.Update();
//		store.display();
//		store.Delete();
//		store.display();
		Scanner s = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("----------Student FeedBack Page----------");
			System.out.println("1.Insert Student Feedback");
			System.out.println("2.Display Student Feedback");
			System.out.println("3.Update Student Feedback");
			System.out.println("4.Delete Student Feedback");
			System.out.println("5. create table or check");
			System.out.println("0. Exit");
			System.out.println("Enter Your Choice: ");
			choice = s.nextInt();
			switch(choice) {
			case 1:
				store.insert1();
				break;
			
			case 2:
				store.display();
				break;
				
			case 3:
				store.Update();
				break;
			case 4:
				store.Delete();
				break;
			case 5:
				StudentFeedbackLogics.create();
				break;
			case 0:
				System.out.println("Exited....Thankyou");
				break;
			default:
				System.out.println("Incorrect Option");
			}
		}while(choice != 0);
	}
}
