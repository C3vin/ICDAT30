package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Example 1:
Input: pattern = "abab", str = "redblueredblue"
Output: true

Example 2:
Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
Output: true

Example 3:
Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false

Notes:
You may assume both pattern and str contains only lowercase letters.
 */
public class n291_Word_Pattern_II {
	public boolean wordPatternMatch(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		HashSet<String> set = new HashSet<String>();
		
		return helper(str, pattern, 0, 0, map, set);
	}
	private boolean helper(String str, String pattern, int i, int j, HashMap<Character, String> map, HashSet<String> set) {
		if(i == str.length() && j == pattern.length()) {
			return true;
		}
		if(i == str.length() || j == pattern.length()) {
			return false;
		}
		
		char c = str.charAt(j);		//get current pattern char
		//if the pattern character exists
		if(map.containsKey(c)) {
			String s = map.get(c);
			
			if(!str.startsWith(s, i)) {
				return false;
			}
			//if it can match, great, continue to match the rest
			return helper(str, pattern, i+s.length(), j+1, map, set);
		}
		//pattern character does not exist in the map
		for(int k=i; k<str.length(); k++) {
			String p = str.substring(i, k+1);
			if(set.contains(p)) {
				continue;
			}
			//create or update it
			map.put(c, p);
			set.add(p);
			
			//continue to match the rest
			if(helper(str, pattern, k+1, j+1, map, set)) {
				return true;
			}
			//backtracking
			map.remove(c);
			set.remove(p);
		}
		return false;
	}
	public static void main(String[] args) {
		n291_Word_Pattern_II obj = new n291_Word_Pattern_II();
		System.out.println(obj.wordPatternMatch("abab", "redblueredblue"));
		System.out.println(obj.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(obj.wordPatternMatch("aabb", "xyzabcxzyabc"));
	}
}
