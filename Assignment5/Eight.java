package Assignment5;

@FunctionalInterface
interface square{
	int sq(int a);
}
@FunctionalInterface
interface addition{
	int add(int a,int b);
}

public class Eight {
	public static void main(String[] args) {
		square s = (a)->a*a;
		System.out.println(s.sq(2));
		
		addition ad = (a,b)->a+b;
		System.out.println(ad.add(5, 5));
	}
}
