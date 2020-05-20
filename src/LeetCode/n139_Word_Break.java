package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented 
into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class n139_Word_Break {
	//DP
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		
		for(int i=1; i<=s.length(); i++) {
			for(int j=0; j<i; j++) {		//F: substring 0 -> i 
				//why check dp[j], cuz need to check if s1 match, then check s2 is in the wordDict
				if(dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;			//set i not j
					break;
				}
			}
		}
		
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		n139_Word_Break obj = new n139_Word_Break();
		System.out.println(obj.wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code"))));
		System.out.println(obj.wordBreak("catsandog", new ArrayList<String>(Arrays.asList("cats","dog","sand","and","cat"))));
	}
}
