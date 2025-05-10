package Microsoft;

public class ReverseWordsInAString {
	public static String ReverseWords(String s) {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') continue;
			int start=i;
			while(i<s.length() && s.charAt(i)!=' ') i++;
			if(result.length() == 0) 
				result.insert(0, s.substring(start,i));
			else
				result.insert(0," ").insert(0, s.substring(start,i));
		}
		return result.toString();
	}
}
