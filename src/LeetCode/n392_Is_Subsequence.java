package LeetCode;

/*
Given two strings s and t, check if s is a subsequence of t.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without 
disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 */
public class n392_Is_Subsequence {
	//Two-Pointers
	public boolean isSubsequence(String s, String t) {
		int sidx = 0;
		int tidx = 0;
		
		while(sidx < s.length() && tidx < t.length()) {
			//move both pointers or just the right pointer
			if(s.charAt(sidx) == t.charAt(tidx)) {
				sidx++;
			}
			
			tidx++;
		}
		
		return sidx == s.length();
	}
	
	//this is for follow up Java Follow up solution - similar as Trie, O(len(s)) each search
	//https://leetcode.com/problems/is-subsequence/discuss/679127/Java-Follow-up-solution-similar-as-Trie-O(len(s))-each-search
	
	//Greedy
	public boolean isSubsequence2(String s, String t) {
		if(s.isEmpty()) {
			return true;
		}
		
		int match = 0;
		
		for(char ch : t.toCharArray()) {
			if(s.charAt(match) == ch && ++match == s.length()) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		n392_Is_Subsequence obj = new n392_Is_Subsequence();
		System.out.println(obj.isSubsequence("abc", "ahbgdc"));
		System.out.println(obj.isSubsequence("axc", "ahbgdc"));
		
		System.out.println(obj.isSubsequence2("abc", "ahbgdc"));
		System.out.println(obj.isSubsequence2("axc", "ahbgdc"));
	}
}
