package Amazon;

public class SubtreeOfAnotherTree {
	public class TreeNode {
		int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
	 }
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null)
            return true;
        if(s==null)
            return false;
        
        if(isIdentical(s,t))
            return true;
        
        return (isSubtree(s.left,t)||isSubtree(s.right,t));
    }
    
    public boolean isIdentical(TreeNode r1, TreeNode r2){
        if(r1 == null && r2==null)
            return true;
        if(r1 == null || r2 == null)
            return false;
        
        if (r1.val != r2.val) return false;
        
        return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
    }
}
