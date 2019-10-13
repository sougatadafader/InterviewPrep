package Wayfair;

public class LongestPallindromeSubstring {
	
	private static int begin;
	private static int maxLen;
	
	public static String LongestPallindrome(String s){
		int len= s.length();
		//if the length of the string is 0 or 1 return the original string
		if(len<2)
			return s;
		for(int i=0; i<len-1;i++)
		{
			extendPalindrome(s, i, i); //assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i+1); //assume even length.
		}
		
		return s.substring(begin, begin + maxLen); //get start and end of palindrome substring
	}

	private static void extendPalindrome(String s, int left, int right) {
		//check if within bounds and then continue moving
		while(left >=0 && right <s.length() && s.charAt(left)==s.charAt(right))
		{
			left -- ;
			
			right ++;
		}
		System.out.println("\nleft is "+ left+" \n right is "+ right);
		
		if(maxLen< right -1 -left)
		{
			begin = left+1; //left+1:  our l-- will go  unequal OR off bounds
			maxLen = right -1 - left; //right-1:  our r++ will go  unequal OR off bounds
		}
		System.out.println("\n"+maxLen);
	}
	public static void main(String[] args) {
		String str = "aaabaaa";
		System.out.println(LongestPallindrome(str));
	}
}
