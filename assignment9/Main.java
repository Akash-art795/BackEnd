package assignment9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		College store = new College();
//		store.create();
//		store.inserts();
//		store.inserts();
//		store.inserts();
//		store.display();
		
		Scanner s = new Scanner(System.in);
		int choice = 0;
//		Employee e = new Employee();
//		e.create();
//		while(choice != 3) {
//			System.out.println("1. Insert data");
//			System.out.println("2. Show Data");
//			System.out.println("3. Exit");
//			System.out.println("Enter Your Choice:");
//			choice = s.nextInt();
//			switch(choice) {
//			case 1:
//				e.inserts();
//				break;
//			case 2:
//				e.display();
//				break;
//			case 3:
//				System.out.println("Exited...");
//				break;
//			default:
//				System.out.println("INVALID OPERATION");
//			}
//		}
		Products p = new Products();
		int c = 0;
		p.create();
		while(c != 3) {
			System.out.println("1. Insert data");
			System.out.println("2. Show Data");
			System.out.println("3. Exit");
			System.out.println("Enter Your Choice:");
			choice = s.nextInt();
			switch(choice) {
			case 1:
				p.inserts();
				break;
			case 2:
				p.display();
				break;
			case 3:
				System.out.println("Exited...");
				break;
			default:
				System.out.println("INVALID OPERATION");
			}
		}
		

	}
}
