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
	private boolean helper(String str, String pattern, int s, int p, HashMap<Character, String> map, HashSet<String> set) {
		if(s == str.length() && p == pattern.length()) {
			return true;
		}
		if(s == str.length() || p == pattern.length()) {
			return false;
		}

		char curPattern = pattern.charAt(p);		 
		//if the pattern character exists
		if(map.containsKey(curPattern)) {
			String value = map.get(curPattern);

			if(!str.startsWith(value, s)) {
				return false;
			}
			//if it can match, great, continue to match the rest
			return helper(str, pattern, s+value.length(), p+1, map, set);
		} else {
			for(int k=s; k<str.length(); k++) {
				String sub = str.substring(s, k+1);
				
				//handle {a=a, b=a}
				if(set.contains(sub)) {
					continue;
				}
				//create or update it
				map.put(curPattern, sub);
				set.add(sub);

				//continue to match the rest
				if(helper(str, pattern, k+1, p+1, map, set)) {
					return true;
				}
				//backtracking
				map.remove(curPattern);
				set.remove(sub);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n291_Word_Pattern_II obj = new n291_Word_Pattern_II();
		System.out.println(obj.wordPatternMatch("ab", "aa"));
		System.out.println(obj.wordPatternMatch("abab", "redblueredblue"));
		System.out.println(obj.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(obj.wordPatternMatch("aabb", "xyzabcxzyabc"));
	}
}
