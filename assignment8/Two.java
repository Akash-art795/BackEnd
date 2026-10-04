package assignment8;

public class Two {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5};
		int sum = 0;
		for(int i : arr) {
			sum+=i;
		}
		int last = arr[arr.length-1];
		int sum1 = 0;
		while(last!=0) {
			sum1+=last;
			last--;
		}
		System.out.println(sum);
		System.out.println(sum1);
		System.out.println("Missing Number: "+(sum1-sum));
	}

}
