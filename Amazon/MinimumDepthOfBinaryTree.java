package Amazon;

public class MinimumDepthOfBinaryTree {
Node root;

public class Node {

int data;
Node left,right;

Node(int val)
{
data = val;
left = right =null;
}
}

public int minDepth(Node root) {
   if (root == null) {
       return 0;
   } else if (root.left != null && root.right != null) {
       return 1+Math.min(minDepth(root.left), minDepth(root.right));
   } else {
       return 1+Math.max(minDepth(root.left), minDepth(root.right));
   }
}


public static void Main(String[] args) {
Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
   root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
   root.right.right.right = new Node(9);
}
}
