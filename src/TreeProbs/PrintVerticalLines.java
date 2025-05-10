package TreeProbs;
/*
 * 
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * 
 *  The idea is to traverse the tree once and get the minimum and maximum horizontal distance 
 *  with respect to root. 
 *  For the tree shown above, minimum distance is -2 (for node with value 4)
 *  and maximum distance is 3 (For node with value 9).
 *  Once we have maximum and minimum distances from root, 
 *  we iterate for each vertical line at distance minimum to maximum from root,
 *  0and for each vertical line traverse the tree and print the nodes which lie on that vertical line.
 */

class MinMax{
	int min,max;
}

public class PrintVerticalLines {
	
	Node root;
	MinMax val =new MinMax();
	
	void findMinMax(Node node,MinMax min,MinMax max, int hd)
	{
		if(node ==null)
			return;
		if(hd<min.min)
			min.min = hd;
		else if(hd>max.max)
			max.max = hd;
		
		findMinMax(node.left,min,max,hd-1);
		findMinMax(node.right, min, max, hd+1);
	}
	
	// A utility function to print all nodes on a given line_no. 
    // hd is horizontal distance of current node with respect to root.
	void printVerticalLine(Node node, int line_no, int hd)
	{
		if(node == null)
		{
			return;
		}
		if(hd==line_no)
		{
			System.out.print	(node.data+" ");
		}
		printVerticalLine(node.left, line_no, hd-1);
		printVerticalLine(node.right, line_no, hd+1);
	}
	
	// The main function that prints a given binary tree in 
    // vertical order 
	void verticalOrder(Node node)
	{
		findMinMax(node, val, val, 0); 
		for(int line_no=val.min;line_no<=val.max;line_no++)
		{
			printVerticalLine(node, line_no, 0);
			System.out.println("");
		}
	}
	public static void main(String args[])  
    {
		PrintVerticalLines tree = new PrintVerticalLines();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
        tree.root.right.right.right = new Node(9); 
  
        System.out.println("vertical order traversal is :"); 
        tree.verticalOrder(tree.root); 
    }
}
