package Amazon;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
		        levelHelper(res, root, 0);
		        return res;
	    }
	    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
		        if (root == null) return;
		        if (height >= res.size()) {
		            res.add(new ArrayList<Integer>());
		        }
	            if(height % 2 == 0)
	            {
	                res.get(height).add(root.val);
	            }
	            else{
	                res.get(height).add(0,root.val);
	            }
		        levelHelper(res, root.left, height+1);
		        levelHelper(res, root.right, height+1);
		    }
}
