package LeetCode;

//Input: "babad"   Output: "bab" 	Note: "aba" is also a valid answer.
//Input: "cbbd"	   Output: "bb"
public class n005_longest_palindromic_substring {
	//For a string is palindrome, it must be mirrored across a central point. 
	//Here we must consider both the even and odd length of the string.
	//So we can iterate the string and check its left and right points to see if it is mirrored. 
	public String longestPalindrome(String s) {  
		if (s.length() == 0)
			return null;
		if (s.length() == 1)
			return s;
	 
		String longest = s.substring(0, 1);				//F: Need this because need to compare with tmp value
		for (int i = 0; i < s.length(); i++) {
			//case 1: odd
			// get longest palindrome with center of i (we can start at i-1, i+1)
			String tmp = helper(s, i, i);		//helper(s, i, i) e.g. bab
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			//case 2: even
			// get longest palindrome with center of i, i+1	e.g. cbbd
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}
	 
	// Given a center, either one letter or two letter,  <- b|e ->
	// Find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {		//F: while loop!!!
			begin--;				//!!! Need to careful. begin is --, because we want go left
			end++;					//!!! end ++ , because we want go right
		}
		return s.substring(begin + 1, end);			//use substring attribute (with +1) to get the string
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
		System.out.println(obj.longestPalindrome(""));
		System.out.println(obj.longestPalindrome("babad"));
		//System.out.println(obj.longestPalindromeDP("babad"));
		//System.out.println(obj.longestPalindromeDP("cbbd"));
	}
}
