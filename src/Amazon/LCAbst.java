package Amazon;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LCAbst {
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            
            if(root==null) return null;
            
            else if(p.val<root.val && q.val<root.val){
                root = root.left;
            }
            
            else if(p.val>root.val && q.val>root.val){
                root= root.right;
            }
            
            else{
                return root;
            }
        }
        
    }
    
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p,TreeNode q) {
    	if(root == null) return null;
        else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestorRecursive(root.left,p,q);
        }
        else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestorRecursive(root.right, p,q);
        }
        else return root;
    }
    
}