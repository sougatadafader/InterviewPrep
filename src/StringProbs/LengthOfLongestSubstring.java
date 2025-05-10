package StringProbs;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	public int slidingWindow(String s) {
		
		if(s == null || s.length() ==0)
		{
			return 0;
		}
		
		Set<Character> set= new HashSet<>();
		int left=0;
		int right=0;
		int max=0;
		while(right<s.length())
		{
			if(set.add(s.charAt(right))) {
				right++;
				max = Math.max(max, right-left);
			}
			else {
				set.remove(s.charAt(left++));
			}
		}
		return max;
		
		
	}
}
