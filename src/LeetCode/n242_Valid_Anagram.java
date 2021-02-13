package LeetCode;

import java.util.Arrays;
/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
import java.util.HashMap;

public class n242_Valid_Anagram {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;

		int[] list = new int[26];
		for(int i=0; i<s.length(); i++) {
			list[s.charAt(i) - 'a']++;
			list[t.charAt(i) - 'a']--;

		}
		for(int i : list) {
			if(i!=0)
				return false;
		}
		return true;
	}

	//sort and compare Good!
	public boolean isAnagram2(String s, String t) {
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();

		Arrays.sort(sch);				//F: if sort, need to convert to char array first.
		Arrays.sort(tch);

		//one way
		//		if(Arrays.equals(sch, tch))		//compare two char array using Arrays.equals.
		//			return true;

		s = String.valueOf(sch);
		t = String.valueOf(tch);

		return s.equals(t);
	}

	//HashMap Good!
	public boolean isAnagram3(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		char[] ss = s.toCharArray();

		for (int i=0; i<ss.length; i++) {
			map.put(ss[i], map.getOrDefault(ss[i], 0)+1);
		}

		char[] tt = t.toCharArray();

		for(int i=0; i<tt.length; i++) {
			map.put(tt[i], map.getOrDefault(tt[i], 0)-1);
		}

		for(int value : map.values()) {
			if(value != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		n242_Valid_Anagram obj = new n242_Valid_Anagram();
		//		String s = "#anagram@"; 
		//		String t = "n#agar@am";
		String s = "anagram"; 
		String t = "nagaram";
		//System.out.println(obj.isAnagram(s, t));		//can't handle unicode
		System.out.println(obj.isAnagram2(s, t));		//OK for unicode
		System.out.println(obj.isAnagram3(s, t));	
	}
}
