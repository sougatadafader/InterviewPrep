package Amazon;

public class OneThreeTwopattern {

	public static boolean find132pattern(int[] nums) {
	    int n = nums.length, top = n, third = Integer.MIN_VALUE;

	    for (int i = n - 1; i >= 0; i--) {
	        if (nums[i] < third) return true;
	        while (top < n && nums[i] > nums[top]) {
	        	third = nums[top++];
	        }
	        nums[--top] = nums[i];
	    }
	    
	    return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1, 3, 2, 0};
		int[] arr2= {1, 6, 6, 6, 2,7};
		System.out.println(find132pattern(arr2));
	}
}
