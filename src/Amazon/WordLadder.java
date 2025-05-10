package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	 public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        HashSet<String> dict = new HashSet<>(wordList);
	        Queue<String> queue = new LinkedList<>();
	        queue.add(beginWord);
	        int level = 1;
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            System.out.println("Queue Size: "+queue.size());
	            for (int q=0; q < size; q++) {
	            	String curString = queue.poll();
	            	System.out.println(curString.toString());
	                char[] cur = curString.toCharArray();
	                
	                for (int i=0; i < cur.length; i++) {
	                    char tmp = cur[i];
	                    for (char chr='a'; chr <= 'z'; chr++) {
	                        cur[i] = chr;
	                        String dest = new String(cur);
	                        if (dict.contains(dest)) {
	                            if (dest.equals(endWord)) {
	                                return level+1;
	                            }
	                            queue.add(dest);
	                            dict.remove(dest);
	                        }
	                    }
	                    cur[i] = tmp;
	                }
	            }
	            level++;
	        }
	        return 0;
	    }
	 
	 public static void main(String[] args) {
		 String beginWord = "hit";
		 String endWord = "cog";
		 
		 String[] wordArray = {"hot","dot","dog","lot","log","cog"};
		 List<String> wordList = Arrays.asList(wordArray);
		 System.out.println(ladderLength(beginWord, endWord, wordList));
	 }
}
