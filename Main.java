package Assignment5;


public final class Main {
	public final void parent() {
		System.out.println("Checking...");
	}
	
	

	public static void main(String[] args) {
		final int n = 105;
		//n = 103;
		System.out.println(n);
		
		int num = 10;
		Integer num1 = num;
		int num2 = num1;
		System.out.println(num2);
		
		
		String value = "100";
        int number = Integer.parseInt(value);

        System.out.println("String value: "+value);
        System.out.println("int value: "+number);
	}
}
