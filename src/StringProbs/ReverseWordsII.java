package StringProbs;

public class ReverseWordsII {

	public char[] reverseWords(char[] str)
	{
		
		int left=0, right = str.length-1;
		reverse(str,left,right);
		for(int i=0;i<=right;++i)
		{
			if(str[i]==' ')
			{
				reverse(str,left, i-1);
				left = i+1;
			}
			if(i==right)
			{
				reverse(str,left,right);
			}
		}
		return str;
	}
	
	private void reverse(char[] str, int left, int right)
	{
		System.out.println(left+" "+right);
		while(left<right)
		{
			char temp = str[left];
			str[left]= str[right];
			str[right]= temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args)
	{
		char[] str = new char[] {'h','e','l','l','o',' ','w','o','r','l','d',' ','D','a','v','e'};
		ReverseWordsII rev = new ReverseWordsII();
		System.out.println(rev.reverseWords(str));
	}
}
