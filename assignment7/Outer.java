package assignment7;

public class Outer {
	private int data = 10;
	
	public class inner {
		public void display() {
			System.out.println(data);
		}
	}
	
	public static void main(String[] args) {
		Outer obj = new Outer();
		Outer.inner innerObj = obj.new inner();
		innerObj.display();
	}
}
