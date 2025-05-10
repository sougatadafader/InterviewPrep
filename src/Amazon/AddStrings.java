package Amazon;

public class AddStrings {

	 public static String addStrings(String num1, String num2) {
	        
	        int i = num1.length() - 1;
	        int j = num2.length() - 1;
	        int carry = 0;
	        char[] num1Array = num1.toCharArray();
	        char[] num2Array = num2.toCharArray();
	        StringBuilder sb = new StringBuilder();
	        while (i >= 0 || j >= 0 || carry == 1) {
	           
	           if(i>=0){
	              carry += num1Array[i]-'0';
	              i--;
	           }
	            if(j>=0){
	                carry += num2Array[j]-'0';
	                j--;
	            }
	            sb.insert(0,carry%10);
	            carry/=10;
	            
	        }
	        return sb.toString();
	        
	    }
	 	public static void main(String[] args) {
	 		System.out.println(addStrings("123", "100"));
	 	}
	 
	 
}
