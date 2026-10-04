package assignment8;

public class Five {

	public static void main(String[] args) {
		int[] a = {2,7,11,15};
		int target = 23;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]+a[j] == target) {
					System.out.println("Target Found: "+a[i]+" "+a[j]);
					return;
				}
			}
		}
		System.out.println("Not Found");
		
	}
		
	
}
