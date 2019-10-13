package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LCAbt {
	
	/*
	 * Iterative
	 * 
	 * */
	
	public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        HashSet<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
	
	
	/*
	 * 
	 * Recursive
	 * 
	 * */
	
	public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null || root == p || root == q) return root;
	    TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
	    TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);
	    return left == null ? right : right == null ? left : root;
	}
	
	
}
