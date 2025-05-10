package Wayfair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. 
 * The data is foratted as list of (parent,child) pairs, where each individual is assigned a unique integer identifier.
 * 
 * parentChildPairs1 = [(1,3),(2,3),(3,6),(5,6),(5,7),(4,5),(4,8),(4,9)(9,11),(14,4),(13,12),(12,9)]
 * 
 * Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if 
 * and only if they share at least one ancestor.
 * 
 *
 * */

public class CommonAncestor {
	
	/*
	 * It is considered that no element is repeating hence the idea of HashSet to make use of O(1) while checking if the element exists.
	 * */
	
	static HashSet<Integer> set =  new HashSet<Integer>();
	
	/*
	 * Queue for performing BFS 
	 * */
	static Queue<Integer> q =  new LinkedList<Integer>();
	
	public static boolean hasCommonAncestor(int[][] arr, int val1,int val2) {
		
		//Add all the parents of value 1 to the queue
		addParent(arr, val1);
		
		//while queue is not empty keep adding the parents of val1 to the HashSet which will be checked later.
		
		while(!q.isEmpty())
		{
			int element = q.poll();
			set.add(element);
			
			//Perform BFS on the current element
			addParent(arr, element);
		}
		
		addParent(arr, val2);
		while(!q.isEmpty()) {
			int element = q.poll();
			if(set.contains(element)) {
				System.out.println("Common ancestor exists");
				set.clear();
				return true;
			}
			else
				addParent(arr, element);
		}
		System.out.println("Common ancestor doesn't exist");
		set.clear();
		return false;
	}
	
	
	public static void addParent(int[][] arr, int val) {
		for(int i=0;i<arr.length;i++){
			if(arr[i][1] == val){
				q.add(arr[i][0]);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		int[][] parentChildPairs1 = new int [][] {
			{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{9,11},{14,4},{13,12},{12,9}
			};
			
			hasCommonAncestor(parentChildPairs1, 3, 8);
			hasCommonAncestor(parentChildPairs1, 5, 8);
			hasCommonAncestor(parentChildPairs1, 6, 8);
			hasCommonAncestor(parentChildPairs1, 6, 9);
			hasCommonAncestor(parentChildPairs1, 1, 3);
			hasCommonAncestor(parentChildPairs1, 7, 11);
			hasCommonAncestor(parentChildPairs1, 6, 5);
			hasCommonAncestor(parentChildPairs1, 5, 6);
			
		int[][] parentChildPais2 =  new int[] [] {
			{11,10},{11,12},{10,2},{10,5},{1,3},{2,3},{3,4},{5,6},{5,7},{7,8}};
			
			
			
			hasCommonAncestor(parentChildPais2, 4, 12);
			hasCommonAncestor(parentChildPais2, 1, 6);
			hasCommonAncestor(parentChildPais2, 1, 12);
			
		}
		

}
