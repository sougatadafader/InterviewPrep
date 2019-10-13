package Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	public class Node {
        int val, x, y;
        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] mergekSortedArrays(int[][] arrays) {
        ArrayList<Integer> rst = new ArrayList<>();
        if (arrays == null || arrays.length == 0) return new int[0];
        
        
        // Faster
        // Somehow, slower: PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(a -> a.val));
        PriorityQueue<Node> queue = new PriorityQueue<Node>(arrays.length,
            new Comparator<Node>() {
        		@Override
                public int compare(Node a, Node b){
                    return a.val - b.val;
                }
            }
        );

        //init
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                queue.offer(new Node(arrays[i][0], i, 0));
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            rst.add(node.val);
            if (node.y < arrays[node.x].length - 1) {
                queue.offer(new Node(arrays[node.x][node.y + 1], node.x, node.y + 1));
            }   
        }

        int[] arrayResult = new int[rst.size()];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = rst.get(i);
        }
        return arrayResult;
    }
}
