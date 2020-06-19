package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
//abcabcbb
//iiiiiiii
//ssss s s
public class n003_longest_substring_without_repeating_characters {
	//Brute Force
	/*	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		for (int i=0; i<s.length(); i++)
			for (int j=i+1; j<s.length()-1; j++)		//j<=n
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j-i);		//?
				}
		return ans;
	}

	private boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<> ();
		for (int i=start; i<end; i++) {
			Character ch = s.charAt(i);		//?
			if (set.contains(ch)) 
				return false;
			set.add(ch);
		}
		return true;
	}*/

	public int lengthOfLongestSubstring(String s) {
		if (s.length()==0) return 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//i = current point, j = start point (non repeating) 
		int max=0;
		int start=0;  
		for (int current = 0; current<s.length(); current++) {
			if (map.containsKey(s.charAt(current))) {
				//update start
				start = Math.max(start, map.get(s.charAt(current)) + 1);		//Need + 1 cuz start need to point next current
				//System.out.println("start: "+start);
			} 
			//can't use else, cuz will miss count max, also will update map value e.g. t=0 -> t=6
			map.put(s.charAt(current), current);	
			max = Math.max(max, current - start + 1);

		}
		return max;
	}
	
	//Sliding Window, HashSet
	public int lengthOfLongestSubstring2(String s) {
		HashSet<Character> set = new HashSet<Character>();	
		
		int n = s.length();
		int res = 0;
		int i = 0;
		int j = 0;
		
		while(i < n && j < n) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				res = Math.max(res, j-i);	
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return res;
 	}
	
	//Sliding Window, HashMap
	public int lengthOfLongestSubstring3(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();		//Character not String type

		int res = 0;
		int start = 0;
		int current = 0;
		
		while(start < s.length() && current < s.length()) {
			if(map.containsKey(s.charAt(current))) {
				//e.g. pwwkew
				//     s ss    (0->2->3)
				start = Math.max(map.get(s.charAt(current))+1, start);	
			}
			map.put(s.charAt(current), current);		//add or update value
			res = Math.max(res, current-start+1);
			current++;
		}
		return res;
	}
	public static void main(String[] args) {
		n003_longest_substring_without_repeating_characters obj = new n003_longest_substring_without_repeating_characters();
//		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(obj.lengthOfLongestSubstring2("abcabcbb"));
//		System.out.println(obj.lengthOfLongestSubstring3("abcabcbb"));
//		System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
//		System.out.println(obj.lengthOfLongestSubstring2("bbbbb"));
//		System.out.println(obj.lengthOfLongestSubstring3("bbbbb"));
		System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
		System.out.println(obj.lengthOfLongestSubstring2("pwwkew"));
		System.out.println(obj.lengthOfLongestSubstring3("pwwkew"));
	}
}
