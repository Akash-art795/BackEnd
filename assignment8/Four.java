package assignment8;

public class Four {
	public static boolean palindrome(int[] a,int left,int right) {
		if(left>=right) {
			return true;
		}
		if(a[left] != a[right]) {
			return false;
		}
		return palindrome(a,left+1,right-1);
	}

	public static void main(String[] args) {
		int[] arr = {10,10,30,20,10,50};
		boolean r = Four.palindrome(arr,0,arr.length-1);
		if(r) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a Palindrome");
		}
	}

}
