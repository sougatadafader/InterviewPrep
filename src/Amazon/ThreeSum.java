package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(n^2)

public class ThreeSum {
	    public List<List<Integer>> threeSum(int[] num) {
	       ArrayList<List<Integer>> ans = new ArrayList<>();
	        int target=0;
		    if(num.length<3)return ans;
		    Arrays.sort(num);
		        for(int j=0; j<num.length-2; j++){
		            if(num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
		            if(num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
		            if(j>0&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
		            int low=j+1, high=num.length-1;
		            while(low<high){
		                int sum=num[j]+num[low]+num[high];
		                if(sum==target){
		                    ans.add(Arrays.asList( num[j], num[low], num[high]));
		                    while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
		                    while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
		                    low++; 
		                    high--;
		                }
		                //move window
		                else if(sum<target)low++; 
		                else high--;
		            }
		        }
		    return ans;
	    }

}
