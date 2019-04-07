package LeetCode;

import java.util.HashMap;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
 */
public class n387_First_Unique_Character_in_a_String {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			Integer t = map.get(s.charAt(i));
			if(t == null) {
				t = new Integer(0);
			}
			map.put(s.charAt(i), t+1);
		}
		for(int j=0; j<s.length(); j++) {
			if(map.get(s.charAt(j)) == 1)
				return j;
		}
		return -1;
	}

	public int firstUniqChar2(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);	//need +1
		}
		
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		n387_First_Unique_Character_in_a_String obj = new n387_First_Unique_Character_in_a_String();
		System.out.println(obj.firstUniqChar("leetcode"));
		System.out.println(obj.firstUniqChar("loveleetcode"));
		
		System.out.println(obj.firstUniqChar2("leetcode"));
		System.out.println(obj.firstUniqChar2("loveleetcode"));
	}
}
