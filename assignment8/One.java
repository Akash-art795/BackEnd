package assignment8;

public class One {
	
	public static void largest(int[] arr) {
		int max = arr[0];
		for(int i : arr) {
			if(i>max) {
				max = i;
			}
		}
		System.out.println("Max: "+max);
	}

	public static void main(String[] args) {
		int[] arr = {10,50,40,20,30,70};
		One.largest(arr);
	}

}
