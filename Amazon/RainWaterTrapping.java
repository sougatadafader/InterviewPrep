package Amazon;

public class RainWaterTrapping {
	
	public static int trap(int[] A) {
	    if (A.length < 3) return 0;
	    
	    int ans = 0;
	    int l = 0, r = A.length - 1;
	    
	    // find the left and right edge which can hold water
	    while (l < r && A[l] <= A[l + 1]) l++;
	    while (l < r && A[r] <= A[r - 1]) r--;
	    
	    while (l < r) {
	        int left = A[l];
	        int right = A[r];
	        if (left <= right) {
	            // add volum until an edge larger than the left edge
	            while (l < r && left >= A[++l]) {
	                ans += left - A[l];
	            }
	        } else {
	            // add volum until an edge larger than the right volum
	            while (l < r && A[--r] <= right) {
	                ans += right - A[r];
	            }
	        }
	    }
	    return ans;
	}
	
	public static void trap2(int[] A) {
		int len = A.length;
		int[] maxLeftToI = new int[len];
		int[] maxRightToI = new int[len];
		
		if(A.length<3)  return;//return 0;
		
		int totalWater=0;
		int maxLeft=A[0];
		maxLeftToI[0]=maxLeft;
		
		int maxRight =0;
		maxRightToI[len-1]=A[len-1];
		
		
		for(int i = 1; i<len;i++) {
			if(A[i]>maxLeft) {
				maxLeft = A[i];
			}
			maxLeftToI[i]=maxLeft;
		}
		
		for(int i = len-1; i>=0;i--) {
			if(A[i]>maxRight) {
				maxRight = A[i];
			}
			maxRightToI[i]=maxRight;
		}
		
		System.out.println("\n");
		for(int i:maxLeftToI) {
			System.out.println(i);
		}
		System.out.println("\n");
		for(int i:maxRightToI) {
			System.out.println(i);
		}
		
		int min;
		for(int i=1;i<len;i++) {
			min = Math.min(maxLeftToI[i], maxRightToI[i]);
			
			totalWater+=min - A[i];
		}
		System.out.println("\nTotal water trapped is: "+ totalWater);
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,1,0,2,1,0,1,3,2,1,2,1};
		int[] arr2= {2,0,2};
		trap2(arr);
	}
	
}
