package Meta;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> output = new ArrayList();
	if(root == null) return output;
	
	Map<Integer,ArrayList> columnTable = new HashMap<>();
	Queue<Pair<Integer, TreeNode>> p =new LinkedList();
	int column =0;
	queue.offer(new Pair(column, root));
	
	int minColumn =0, maxColumn=0;
	while(!queue.isEmpty()) {
		Pair<Integer,TreeNode> p = queue.poll();
		column = p.getKey();
		root = p.getValue();
		
		if(root!=null) {
			if(!columnTable.containsKey(column)) {
				columnTable.put(column,new ArrayList<Integer>());
			}
			
			columnTable.get(column).add(root.val);
			minColumn = Math.min(minColumn, column);
			maxColumn = Math.max(maxColumn,column);
			
			queue.offer(column-1,root.left);
			queue.offer(column+1,root.right);
		}
	}
	for(int i=minColumn; i<=maxColumn; i++) {
		output.add(columnTable.get(i));
	}
	
	return output;
}
