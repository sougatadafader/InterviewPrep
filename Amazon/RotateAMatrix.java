package Amazon;

public class RotateAMatrix {
	
	public static int[][] rotateImage(int[][] matrix){
		int rotatedmatrix[][] = new int[matrix[0].length][matrix.length];
		int offset = matrix.length - 1;
		for(int row = 0; row< matrix.length; row++){			
			for(int col=0;col<matrix[0].length;col++){
				rotatedmatrix[col][offset] = matrix[row][col];
			}
			offset--;
			
		}
		return rotatedmatrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{2,3,4,5},{4,0,8,9},{3,7,2,0}};
		int[][] matrix2 = {{0,1},{2,3}};
		int[][] matrix3 = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
		int rotatedmatrix[][];
		rotatedmatrix = rotateImage(matrix3);
		for(int row = 0;row< rotatedmatrix.length;row++){
			for(int col=0;col<rotatedmatrix[0].length;col++){
				System.out.print(rotatedmatrix[row][col]);
			}
			System.out.println();
		}
	}

}