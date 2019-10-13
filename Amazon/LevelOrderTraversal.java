package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LevelOrderTraversal {
	
	/*
	 * 
	 * Level order iterative
	 * 
	 * */
	
	
	 public List<List<Integer>> levelOrderIterable(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
	        
	        if(root == null) return wrapList;
	        
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int levelNum = queue.size();
	            List<Integer> subList = new LinkedList<Integer>();
	            for(int i=0; i<levelNum; i++) {
	                if(queue.peek().left != null) queue.offer(queue.peek().left);
	                if(queue.peek().right != null) queue.offer(queue.peek().right);
	                subList.add(queue.poll().val);
	            }
	            wrapList.add(subList);
	        }
	        return wrapList;
	    }
	 
	 /*
	  * Level order recursive 
	  * 
	  * */
	 
	 public List<List<Integer>> levelOrderRecursive(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        levelHelper(res, root, 0);
	        return res;
	    }
	 
	 public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
	        if (root == null) return;
	        if (height >= res.size()) {
	            res.add(new LinkedList<Integer>());
	        }
	        res.get(height).add(root.val);
	        levelHelper(res, root.left, height+1);
	        levelHelper(res, root.right, height+1);
	    }
	 	

}
