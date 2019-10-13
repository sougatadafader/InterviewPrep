package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		if (s.length()==0) return 0;
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        int max=0;
        for (int right=0, left=0; right<s.length(); right++){
        	//System.out.println(s.charAt(i));
            if (map.containsKey(s.charAt(right))){
            	
          
                left = Math.max(left,map.get(s.charAt(right))+1);
                
                System.out.println(s.charAt(right) + " already exists so left = "+left);
            }
            System.out.println("putting "+s.charAt(right) + " at "+right);
            map.put(s.charAt(right),right);
            max = Math.max(max,right-left+1);
        }
        
        Iterator<Entry<Character,Integer>> itr = map.entrySet().iterator();
        
        while(itr.hasNext()) {
            Entry<Character, Integer> entry = itr.next(); 

        	//System.out.println(entry.getKey());
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		String s1 = "abcabcbb";
		String s2 = "pwwkew";
		String s3 = "bacaa";
		String s4 = "daaabcd";
		System.out.println(lengthOfLongestSubstring(s4));
	}

}
