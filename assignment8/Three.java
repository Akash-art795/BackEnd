package assignment8;

public class Three {
	public static void reverse(int[] a , int left, int right) {
		if(left>=right) {
			return;
		}
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		left++;right--;
		reverse(a,left,right);
	}

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,70};
		int left = 0; int right = arr.length-1;
		Three.reverse(arr, left,right);
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
