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
    	return res;
    }
	private void dfs(String s, int start, List<String> tmp, List<List<String>> res) {
		if(start == s.length()) {
			res.add(new ArrayList<String>(tmp));
			return;
		}
		for(int i=start; i<s.length(); i++) {
			if(isParlindrome(s.toCharArray(), start, i)) {
				tmp.add(s.substring(start, i+1));
				dfs(s, i+1, tmp, res);						//i+1
				tmp.remove(tmp.size()-1);
			}
		}
	}
	private boolean isParlindrome(char[] c, int left, int right) {
		while(left < right) {
			if(c[left] != c[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public List<List<String>> partition2(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	List<String> tmp = new ArrayList<String>();
    	dfs(s, 0, tmp, res);
    	return res;
	}
	private void dfs2(String s, int start, List<String> tmp, List<List<String>> res) {
		if(start == s.length()) {
			res.add(new ArrayList<String>(tmp));
			return;
		}
		for(int i=start; i<s.length(); i++) {
			String sub = s.substring(start, i+1);
			if(!isParlindrome2(sub)) {
				continue;
			}
			tmp.add(sub);
			dfs2(s, i+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}
	}
	
	private boolean isParlindrome2(String sub) {
		int left = 0;
		int right = sub.length()-1;
		while(left < right) {
			if(sub.charAt(left) != sub.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	public static void main(String[] args) {
    	n131_Palindrome_Partitioning obj = new n131_Palindrome_Partitioning();
    	System.out.println(obj.partition("aab"));
    	System.out.println(obj.partition2("aab"));
    }
}
