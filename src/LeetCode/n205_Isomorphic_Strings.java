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
				if(map.get(ss) != tt) {     //if(!map.get(ss).equals(tt))
					return false;
				}
			} else {						
				if(map.containsValue(tt)) 	//need "containValue"
					return false;
				map.put(ss, tt);
			}
		}
		return true;
	}
	
	//sol2: cool but !
	public boolean isIsomorphic2(String s, String t) {
		HashMap map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			//why +"", cuz put will return null and add new value. 
			//e.g. //{p=2, a=1, r=4, t=2, e=3, e=4, i=1, l=3}
			//Main idea is using single HashMap as two HashMaps with different keys. 
			if(map.put(s.charAt(i), i) != map.put(t.charAt(i)+"", i)) { 
				System.out.println(map);
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		n205_Isomorphic_Strings obj = new n205_Isomorphic_Strings();
		System.out.println(obj.isIsomorphic("egg", "add"));
		System.out.println(obj.isIsomorphic("foo", "bar"));
		System.out.println(obj.isIsomorphic("paper", "title"));
		
		System.out.println(obj.isIsomorphic2("egg", "add"));
		System.out.println(obj.isIsomorphic2("foo", "bar"));
		System.out.println(obj.isIsomorphic2("paper", "title"));
	}
}
