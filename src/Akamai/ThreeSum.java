package Akamai;

import java.util.Arrays;

public class ThreeSum {

	public static void findTriplet(int[] arr,int target) {
		
		int left,right;
		int len = arr.length-1;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			left = i+1;
			right = len-1;
			System.out.println("left: "+left+" right: "+right);
			while(left<right) {
				if(arr[i]+arr[left]+arr[right]==target) {
					System.out.println("Triplet is: "+ arr[i]+" "+arr[left]+" "+arr[right]);
					return;
				}
				else if(arr[i]+arr[left]+arr[right]<target) {
					left++;
				}
				else
					right--;
			}
			
		}
		System.out.println("Triplet not found");

	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {5,21,-1,10,2,7,4,0,0};
		int target = 17;
		findTriplet(arr, target);
	}
}
