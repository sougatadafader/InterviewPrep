package Stack;

import java.util.Stack;

public class ValidParanthesis {
	public static boolean isValidParanthesis(String s) {
		if(s.length()>0)
		{
			Stack<Character> st = new Stack<Character>();
			for(char c: s.toCharArray())
			{
				if(c=='(')
				{
					st.push(')');
				}
				else if(c=='[')
				{
					st.push(']');
				}
				else if(c=='{')
				{
					st.push('}');
				}
				else if(st.pop()!=c)
				{
					return false;
				}
			}
			
			return st.isEmpty();
		}
		return false;
	}

}
