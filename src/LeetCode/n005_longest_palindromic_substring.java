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
	        System.out.println("left: " + left + " right:" + right);
	        String str = lengthOfPalindrome(s,left,right);  
	        System.out.println("str:" + str);
	        if(maxLen < str.length()) {  
	            maxLen = str.length();  
	            res = str;  
	        }  
	    }  
	    return res;  
	}  
	private String lengthOfPalindrome(String s, int left, int right) {  
	    while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {  
	    	left--;  
	        right++;  
	    }  
	    return s.substring(left+1,right);  
	} 
	
	//DP
	public String longestPalindromeDP(String s) {  
	    if(s == null || s.length()==0)  
	        return "";  
	    
	    boolean[][] palin = new boolean[s.length()][s.length()];  
	    String res = "";  
	    int maxLen = 0;  
	    
	    // i(<---) | j(--->)
	    for(int i=s.length()-1; i>=0; i--) {  
	        for(int j=i; j<s.length(); j++) {  
	            if(s.charAt(i) == s.charAt(j) && (j-i<=2 || palin[i+1][j-1])) {  
	            	palin[i][j] = true;  
	                if(maxLen < j-i+1) {  
	                    maxLen = j-i+1;  
	                    res = s.substring(i,j+1);  
	                }  
	            }  
	        }  
	    }  
	    return res;  
	} 
	
	public static void main(String[] args) {
		n005_longest_palindromic_substring obj = new n005_longest_palindromic_substring();
		System.out.println(obj.longestPalindrome("abba"));
		System.out.println(obj.longestPalindromeDP("abba"));
	}
}
