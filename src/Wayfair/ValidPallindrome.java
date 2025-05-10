package Wayfair;

public class ValidPallindrome {

	public static boolean isPallindrome(String s) {
		String st="aa";
		st = st + "c";
		int left = 0;
		int right =  s.length()-1;
		while(left<right)
		{
			while(left<right && !Character.isLetterOrDigit(s.charAt(left)))
			{
				left++;
			}
			while(left<right && !Character.isLetterOrDigit(s.charAt(right)))
			{
				right++;
			}
			
			if(left<right && Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args)
	{
		System.out.println(isPallindrome("Heh"));
	}
}
