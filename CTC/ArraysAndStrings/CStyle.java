package CTC.ArraysAndStrings;

public class CStyle {

	public static String getReverseCStyle(String str){
		StringBuffer sb = new StringBuffer();
		for(int i = str.length()-1; i>=0 ;i--){
			sb.append(str.charAt(i));
		}
		sb.append('\0');
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CStyle.getReverseCStyle("abcd"));
		System.out.println(CStyle.getReverseCStyle("abcd").length());
	}

}
