package assignmnent13;

class Thread1 extends Thread{
	public void run() {
		try {
			System.out.println("Thread-1");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
class Thread2 extends Thread{
	public void run() {
		try {
			System.out.println("Thread-2");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
class normal {
	public static void method() {
		System.out.println("Normal Method");
	}
}
public class Task{
	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		Thread t2 = new Thread2();
		t1.start(); t2.start();
		
		t1.join();
		t2.join();
		
		normal.method();
	}
}

