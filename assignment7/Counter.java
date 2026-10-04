package assignment7;

public class Counter {
	public static int count = 0;
	public Counter() {
		count++;
		System.out.println(count);
	}
	public static void displayCount() {
		System.out.println("Current Count: "+count);
	}
	
	public static void main(String[] args) {
		Counter c = new Counter();
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		
		Counter.displayCount();
		

	}

}
