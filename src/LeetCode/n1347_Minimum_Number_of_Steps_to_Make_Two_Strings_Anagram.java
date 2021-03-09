package LeetCode;

import java.util.HashMap;

/*
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.
An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
Example 4:

Input: s = "xxyyzz", t = "xxyyzz"
Output: 0
Example 5:

Input: s = "friend", t = "family"
Output: 4

Constraints:
1 <= s.length <= 50000
s.length == t.length
s and t contain lower-case English letters only.
 */
public class n1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
	//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/discuss/601103/ONLY-SOLUTION-THAT-BEATS-100-TIME-AND-100-SPACE!
	public int minSteps(String s, String t) {
		int res = 0;

		int[] arr = new int[26];
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();

		for(int i=0; i<s.length(); i++) {
			arr[sc[i] - 'a']++;
			arr[tc[i] - 'a']--;
		}

		for(int a : arr) {
			if(a > 0) {
				res = res + a;
			}
		}

		return res;
	}

	//Good! HashMap sol
	public int minSteps2(String s, String t) {
		int res = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);	//{c=1, t=1, d=1, e=3, l=1, o=1}
		}
		
		//if the map contains one of the character with at least 1 frequency, we subtract the frequency
		for(int i=0; i<t.length(); i++) {
			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0) {
				map.put(t.charAt(i), map.get(t.charAt(i))-1);			//{c=0, t=0, d=1, e=2, l=1, o=1}
			} else {
				res++;		 //otherwise increment the steps needed to make t anagram
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		n1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram obj = new n1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram();
		System.out.println(obj.minSteps("leetcode", "practice"));
		System.out.println(obj.minSteps2("leetcode", "practice"));
	}
}
