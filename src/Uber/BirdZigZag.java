package Uber;
import java.util.*;

public class BirdZigZag {
	public static int[] findZigZagPath(int[] arr, int startPos, int targetSum) {
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Fill leftQueue: from left of startPos to 0
        for (int i = startPos - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                leftQueue.offer(i);
            }
        }

        // Fill rightQueue: from right of startPos to end
        for (int i = startPos + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                rightQueue.offer(i);
            }
        }

        int sum = 0;
        boolean goRight = true;

        while (sum < targetSum && (!leftQueue.isEmpty() || !rightQueue.isEmpty())) {
            if (goRight && !rightQueue.isEmpty()) {
                int index = rightQueue.poll();
                sum += arr[index];
                result.add(index);
            } else if (!goRight && !leftQueue.isEmpty()) {
                int index = leftQueue.poll();
                sum += arr[index];
                result.add(index);
            }
            goRight = !goRight;
        }

        // Convert List<Integer> to int[]
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        return sum >= targetSum ? finalResult : new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {50, 0, 50};
        int startPos = 1;
        int targetSum = 100;

        int[] path = findZigZagPath(arr, startPos, targetSum);
        System.out.println(Arrays.toString(path)); // Output: [2, 0]
    }

}
