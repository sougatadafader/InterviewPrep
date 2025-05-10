package Meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Element {
	int value;
	int arrayIndex;
	int elementIndex;
	
	public Element(int value, int arrayIndex, int elementIndex) {
		this.value = value;
		this.arrayIndex = arrayIndex;
		this.elementIndex = elementIndex;
	}
}
public class MergeKSortedArrays {
	public static int[] mergeKSortedArrays(int[][] arrays) {
		PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e->e.value));
		List<Integer> temp = new ArrayList<>();
		
		//Add first element from each array into the priorityQueue.
		for(int i = 0; i<arrays.length;i++) {
			if (arrays[i] != null && arrays[i].length > 0) {
				minHeap.offer(new Element(arrays[i][0],i,0));
			}
		}
		
		//Process the heap
		
		while(!minHeap.isEmpty()) {
			Element currentElement = minHeap.poll();
			temp.add(currentElement.value);
			int nextIndex = currentElement.elementIndex+1;
			if(nextIndex<arrays[currentElement.arrayIndex].length) {
				minHeap.offer(new Element(arrays[currentElement.arrayIndex][nextIndex],currentElement.arrayIndex,nextIndex));
			}
		}
		return temp.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 5},
            {},
            {1, 3, 4},
            {2, 6},
            {},
            {0, 7}
        };

        int[] merged = mergeKSortedArrays(arrays);
        System.out.println(Arrays.toString(merged));
    }
}
