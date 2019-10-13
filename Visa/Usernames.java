package Visa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Usernames {

	public static List<String> usernamesSystem(List<String> u) {
        // Write your code here

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s : u) {
            map.put(s, map.getOrDefault(s, -1) + 1);
        }
        
        
        List<String> res = new ArrayList<>();
        for (int i=u.size()-1;i>=0;i--) {
            String s = u.get(i);
            res.add(s + (map.get(s)!=0?map.get(s):""));
            map.put(s, map.get(s) - 1);
        }

        Collections.reverse(res);
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> u = new ArrayList<>();
		u.add("alex");
		u.add("sougata");
		u.add("alex");
		u.add("todd");
		List<String> result = usernamesSystem(u);
		for(String item:result) {
			System.out.println(item);
		}
	}

}
