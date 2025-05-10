package GoldmanSachs;

public class SqrtSolution {
	    public int mySqrt(int x) {
	        if(x<2) return x;

	        long num;
	        int pivot = 2;
	        int left = 2;
	        int right = x/2;

	        //We will try Binary Search

	        while(left<=right) {
	            pivot = left + (right - left) /2;
	            num = (long) pivot * pivot;
	            if(num < x) left = pivot +1;
	            else if (num > x) right = pivot -1;
	            else return pivot;
	        }
	        return right;
	    }
}
