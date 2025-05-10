package Amazon;

public class KthSmallestElement {
	
	public static int findKthSmallest(int[] nums, int k) {
		  return quickSelect(nums, 0, nums.length - 1, k);
		}
		    
		    static void swap(int[] nums, int a, int b) {
		        int temp = nums[a];
		        nums[a] = nums[b];
		        nums[b] = temp;
		    }

		    static int quickSelect(int[] nums, int low, int high, int k) {
				  int index = low;
				   int pivot =high;
				  // use quick sort's idea
				  // put nums that are <= pivot to the left
				  // put nums that are  > pivot to the right
				  for (int j = low; j < high; j++) {
				    if (nums[j] <= nums[pivot]) {
				    	System.out.println("\nfor value of j: "+ j+" value of index is: "+index+"\n");
				    	swap(nums, index++, j);
				    	for(int l: nums) {
				    		System.out.print(" "+l);
				    	}
				    }
				  }
				  
				  System.out.println("The Index is:"+ index);
				  for(int num:nums) {
					  System.out.print(" "+num);
				  }
				  System.out.println("\n");
				  
				  swap(nums, index, pivot);
				    
				  
				  // count the nums that are > pivot from high
				  int count = index-low + 1;
				  // pivot is the one!
				  if (count == k) return nums[index];
				  // pivot is too small, so it must be on the right
				  if (count < k) return quickSelect(nums, index + 1, high, k-count);
				  // pivot is too big, so it must be on the left
				  return quickSelect(nums, low, index - 1, k);
				}

	
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		int k=2;
		//findKthSmallest(arr, k);
		System.out.println(findKthSmallest(arr, k));
		System.out.println("final----");
		for(int num:arr) {
			  System.out.print(" "+num);
		  }
		  System.out.println("\n");
	}

}
