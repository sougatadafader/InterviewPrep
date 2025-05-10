package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class CourseScheduling {
	
	int n;
    int[] indegree;
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        indegree = new int[n];
        for(int[] pr : prerequisites){
            List<Integer> l =  adj.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]); indegree[pr[0]]++;
            adj.put(pr[1], l);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) q.add(i); 
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(indegree[cur] == 0)count++;
            if(!adj.containsKey(cur)) continue;
            for(int nei : adj.get(cur)){
                indegree[nei]--;
                if(indegree[nei]== 0) q.add(nei);
            }

        }

        return count == n;
    }

}
