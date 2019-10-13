package Amazon;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumModified {
	
	public static void twoSumModified(int[] array,int target)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();  
		for(int i:array)
		{
			hm.put(i,i );
		}
		
	}
	
	public static void main()
	{
		int[] arr= {1,3,4,12,10,9};
		int target =10;
		twoSumModified(arr, target);
	}

}
