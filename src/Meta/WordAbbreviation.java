package Meta;

public class WordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        int num=0;
        int length =word.length();
        System.out.println("New length: "+ length);
        for(int i=0;i<abbr.length();i++){
        	System.out.println("current char " + abbr.charAt(i));
            if(abbr.charAt(i)-'0' ==0 && num==0) return false;
            if(abbr.charAt(i)-'a'>=0){
            	System.out.println("inside if "+ i);
            	
            	if(num>0) {
            		length=length-num;
                    System.out.println(" length after reduction: "+ length);
                    num=0;
            	}
            	
                //encountered letter
                if(abbr.charAt(i)==word.charAt(word.length()-length)) {
                	length=length-1;
                	System.out.println("Length is: "+ length);
                	System.out.println("Char: "+ word.charAt(num));
                }
            }
            else {
            	System.out.println("inside else "+ i);
                if(num==0){
                    num = abbr.charAt(i) -'0';
                    System.out.println(" num : "+num);

                    if(length-num==0) {
                    	System.out.println("Yes");
                    	length=length-num;
                    }
                }
                else if(num<10) {
                    num = num*10 + abbr.charAt(i) -'0';
                    System.out.println(" num: "+ num);
                    
                }
            }
        }
        System.out.println("Final length remaining: " + length);
        return length==0;
    }
	public static void main(String[] args) {
		String word = "hi";
		String abb = "hi1";
		System.out.println(""+ new WordAbbreviation().validWordAbbreviation(word, abb));
	}
}

