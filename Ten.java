package Assignment5;

import java.util.ArrayList;

public class Ten {
	public static void main(String[] args) {
		ArrayList<String> n = new ArrayList<>();
		n.add("Akash");
		n.add("Harish");
		n.add("Rahul");
		n.add("Vetri");
		n.forEach(name -> System.out.println(name));
	}
}
