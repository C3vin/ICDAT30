package LeetCode;

public class n005_longest_palindromic_substring {
	public String longestPalindrome(String s) {  
		if (s.isEmpty())
			return null;
	 
		if (s.length() == 1)
			return s;
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i (we can start at i-1, i+1)
			String tmp = helper(s, i-1, i+1);		//helper(s, i, i)
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}
	 
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {		//F: end range
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
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
