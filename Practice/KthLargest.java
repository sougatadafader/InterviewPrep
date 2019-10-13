package Practice;

import java.util.Random;

public class KthLargest {

	public int findKthLargest(int[] arr, int k) {
		int n = arr.length;
		int left = 0 ;
		int right = n-1;
		Random rand = new Random();
		while(left<=right) {
			int chosenPivot = rand.nextInt(right - left + 1) + left;
			int finalIndexOfChosenPivot = partition(arr,left,right,chosenPivot);
		
			if(finalIndexOfChosenPivot==n-k) {
				return arr[finalIndexOfChosenPivot];
			}
			else if(finalIndexOfChosenPivot > n-k) {
				right = finalIndexOfChosenPivot-1;
			}
			else {
				left = finalIndexOfChosenPivot+1;
			}
		}
		return -1;
	}
	
	private int partition(int[] arr,int left,int right, int pivot) {
		int pivotVal = arr[pivot];
		int lesserItemsTailIndex = left;
		swap (arr,pivot,right);
		for(int i=left; i<right; i++) {
			if(arr[i]<pivotVal) {
				swap(arr, i,lesserItemsTailIndex);
				lesserItemsTailIndex++;
			}
		}
		swap(arr, right, lesserItemsTailIndex);
		return lesserItemsTailIndex;
	}
	private void swap(int[] arr, int first, int second) {
		  int temp = arr[first];
		  arr[first] = arr[second];
		  arr[second] = temp;
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
