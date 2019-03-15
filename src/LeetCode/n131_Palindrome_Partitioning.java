package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class n131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	List<String> tmp = new ArrayList<String>();
    	dfs(s, 0, tmp, res);
    }
	public static void main(String[] args) {
    	n131_Palindrome_Partitioning obj = new n131_Palindrome_Partitioning();
    	System.out.println(obj.partition("aab"));
    }
}
