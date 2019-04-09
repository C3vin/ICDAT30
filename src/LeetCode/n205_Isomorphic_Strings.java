package LeetCode;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */
public class n205_Isomorphic_Strings {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) return false;
		if(s == null || t == null) return false;

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for(int i=0; i<s.length(); i++) {
			char ss = s.charAt(i);
			char tt = t.charAt(i);

			if(map.containsKey(ss)) {
				if(map.get(ss) != tt) {
					return false;
				}
			}else {	//If a value is already mapped, it can not be mapped again.
				if(map.containsValue(tt)) //if tt is already being mapped
					return false;
				map.put(ss, tt);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		n205_Isomorphic_Strings obj = new n205_Isomorphic_Strings();
		System.out.println(obj.isIsomorphic("egg", "add"));
		System.out.println(obj.isIsomorphic("foo", "bar"));
		System.out.println(obj.isIsomorphic("paper", "title"));
	}
}
