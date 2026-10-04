package Assignment5;

public class Student {
	String name;
	String college = "ABC College";
	public Student(String name) {
		this.name = name;
	}
	public void display() {
		System.out.println("Student Name: "+name);
		System.out.println("College Name: "+college);
	}
	public static void main(String[] args) {
		Student s1 = new Student("Akash");
		Student s2 = new Student("Harish");
		
		s1.display();s2.display();
	}
}
