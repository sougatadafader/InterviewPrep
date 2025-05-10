package Amazon;

import java.util.LinkedList;

class LinkedListNode{
	int data; 
	LinkedListNode next;
	
    LinkedListNode(int d) 
    { 
        data = d; 
        next = null; 
    }

	 
}

public class ReverseALinkedList {

	public static LinkedListNode reverseIterative(LinkedListNode node) {
		
		if(node == null || node.next == null)return node;
		
		LinkedListNode current = node;
		LinkedListNode prev = null;
		
		while(current!=null) {
			LinkedListNode next = current.next;
			current.next = prev;
			prev = current;
			current =next;
		}
		
		return prev;
	}
	
	public static LinkedListNode reverseRecursive(LinkedListNode node) {
		
		if(node == null || node.next ==null) return node;		
		LinkedListNode secondNode = node.next;
		node.next =null;
		return recursiveHelper(secondNode,node);
	}
	
	public static LinkedListNode recursiveHelper(LinkedListNode currentnode,LinkedListNode previous) {
		if(currentnode==null)
			return previous;
		LinkedListNode next = currentnode.next;
		currentnode.next = previous;
		return recursiveHelper(next, currentnode);
	}
	
	
	public static void main(String[] args) {
		 
		LinkedListNode listHead;
		listHead = new LinkedListNode(85);
		listHead.next = new LinkedListNode(15);
		listHead.next.next = new LinkedListNode(4);
		listHead.next.next.next = new LinkedListNode(20);
		
		LinkedListNode reverse =  reverseRecursive(listHead);
		while(reverse!=null) {
			System.out.println(reverse.data);
			reverse = reverse.next;
		}
	}
}
