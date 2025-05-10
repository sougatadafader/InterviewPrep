package Amazon;

import java.util.Stack;

public class DoesNodeExist {

	boolean doesNodeExist(TreeNode root, int target) {
		  if (root == null) return false;
		  Stack<Integer> stack = new Stack<>();
		  int temp = target;
		  while (temp > 1) {
		    stack.push(temp);
		    temp /= 2;
		  }
		  while (!stack.isEmpty()) {
		    if (stack.pop() % 2 == 0) root = root.left;
		    else root = root.right;
		    if (root == null) return false;
		  }
		  return true;
		}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
	}
}
