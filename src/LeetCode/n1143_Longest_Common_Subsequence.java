package LeetCode;

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */
public class n1143_Longest_Common_Subsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		char[] ch1 = text1.toCharArray();
		char[] ch2 = text2.toCharArray();
		
		int[][] dp = new int[ch1.length+1][ch2.length+1];
		
		for(int i=0; i<ch1.length; i++) {
			for(int j=0; j<ch2.length; j++) {
				if(ch1[i] == ch2[j]) {
					dp[i+1][j+1] = dp[i][j]+1;
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		
		return dp[ch1.length][ch2.length];
	}
	
	public static void main(String[] args) {
		n1143_Longest_Common_Subsequence obj = new n1143_Longest_Common_Subsequence();
		System.out.println(obj.longestCommonSubsequence("abcde", "ace"));
	}
}
