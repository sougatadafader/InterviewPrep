package Amazon;


/*
 *You are in charge of preparing a recently purchased lot for Amazon’s building. 
 *The lot is covered with trenches and has a single obstacle that needs to be taken down 
 *before the foundation is prepared for the building. 
 *The demolition robot must remove the obstacle before the progress can be made on the building.
 *Write an algorithm to determine the minimum distance required for the demolition robot to remove the obstacle.
 *
 *
 *Assumptions:
 *• The lot is flat, except the trenches and can be represented by a 2D grid.
 *• The demolition robot must start at the top left corner of the lot, which is always flat, and
 *  can move on block up, down, right, left
 *• The demolition robot cannot enter trenches and cannot leave the lot.
 *• The flat areas are indicated by 1, areas with trenches are indicated by 0, and the obstacle is indicated by 9
 * 
 * Input:
 * The input of the function has 3 arguments: numRows – number of rows 
 * numColumns – number of columns
 * lot – 2d grid of integers
 * 
 * Output:
 * Return an integer that indicated the minimum distance traversed to remove the obstacle else return -1
 * 
 * Constraints:
 * 1<= numRows, numColumns <= 1000
 * 
 * 
 * 
 * 
 * */



import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

import java.util.ArrayList;

public class MinDistanceToRemoveObstacle {
/**
*
* @param numRows
* @param numColumns
* @param lot
 * @return 
* @return
*/
static int removeObstacles(int numRows, int numColumns, List<List> lot) {
int[][] grid = new int[numRows][numColumns];
boolean[][] visited = new boolean[numRows][numColumns];

    for(int i = 0  ;i < lot.size(); i++) {
        List<Integer> sub = lot.get(i);
        for(int j = 0 ; j < sub.size(); j++) {
            grid[i][j] = (int) lot.get(i).get(j);
        }
    }

    int count = 0;
    int target = 9;
    int[][] directions = new int[][]{{1,0}, {-1,0}, {0, 1}, {0, -1}};

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{0,0});
    while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i = 0 ;i < size; i++) {
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];

            if(row < 0 || column < 0 || row >= numRows || column>= numColumns || grid[row][column] == 0 || visited[row][column]) {
                continue;
            }

            visited[row][column] = true;
            if(grid[row][column] == target) {
                return count;
            }

            for(int[] dir : directions) {
                int nr = dir[0] + row;
                int nc = dir[1] + column;
                queue.offer(new int[]{nr, nc});
            }
        }
        count++;
    }
    return -1;
}

	public static void main(String[] args)
	{
		List<Integer> l1  = new ArrayList<Integer>();
		l1.add(1);
		l1.add(0);
		l1.add(0);
		List<Integer> l2  = new ArrayList<Integer>();
		l2.add(1);
		l2.add(0);
		l2.add(0);
		List<Integer> l3  = new ArrayList<Integer>();
		l3.add(1);
		l3.add(9);
		l3.add(1);
		
		List<List> lot = new ArrayList<List>();
		lot.add(l1);
		lot.add(l2);
		lot.add(l3);
		System.out.println(removeObstacles(3, 3, lot));
	
	}

}

