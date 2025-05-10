package Visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams {
	public static List<String> funWithAnagrams(List<String> strList){
        Set<String> set = new HashSet<>();
        Set<String> result =  new TreeSet<>();
        for(String s:strList){
            char []arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(!set.contains(sortedStr)) {
                result.add(s);
            }
            set.add(sortedStr);
        }

        return new ArrayList<String>(result);
    }
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("code");
		list.add("aaagmnrs");
		list.add("anagrams");
		list.add("doce");
		List<String> l2 = funWithAnagrams(list);
		
		for(String item:l2) {
			System.out.println(item);
		}
	}

}
