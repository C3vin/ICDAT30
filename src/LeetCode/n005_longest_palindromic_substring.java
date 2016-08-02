package LeetCode;

public class n005_longest_palindromic_substring {
	public String longestPalindrome(String s) {  
	    if(s == null || s.length()==0)  
	        return "";  
	    
	    int maxLen = 0;  
	    String res = "";
	    
	    for(int i=0; i<2*s.length()-1; i++) {  
	        int left = i/2;  
	        int right = i/2;  
	        if(i%2 == 1) { 
	            right++;  
	        }
	        System.out.println("left: " + left + " right: " + right);
	        String str = lengthOfPalindrome(s,left,right);  
	        System.out.println("str: " + str);
	        if(maxLen < str.length())  
	        {  
	        	//System.out.println("maxLen1: " + maxLen);
	            maxLen = str.length();  
	            System.out.println("maxLen2: " + maxLen + " str: " + str);
	            res = str;  
	        }  
	    }  
	    
	    return res;  
	}  
	private String lengthOfPalindrome(String s, int left, int right) {  
	    while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {  
	    	System.out.println("charAt(left): " + s.charAt(left) + " charAt(right): " + s.charAt(right));
	    	left--;  
	        right++;  
	        System.out.println("#left: " + left + " #right: " + right);
	    }  
	    return s.substring(left+1,right);  
	} 
	
	public static void main(String[] args) {
		n005_longest_palindromic_substring obj = new n005_longest_palindromic_substring();
		System.out.println(obj.longestPalindrome("abba"));
	}
}
