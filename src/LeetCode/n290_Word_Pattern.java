package LeetCode;

import java.util.HashMap;

/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class n290_Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		
		String[] s = str.split(" ");				    //need []
		if(s.length != pattern.length())
			return false;

		for(int i=0; i<pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(map.containsKey(c)){
				if(!map.get(c).equals(s[i])) {			//use equals()
					return false;
				}
			} else {
				if(map.containsValue(s[i])) {			//need "containValue(value)"
					return false;
				}
				map.put(c, s[i]);
			}	
		}
		return true;
	}
	
	//sol2
	public boolean wordPattern2(String pattern, String str) {
		HashMap<Object, Integer> map = new HashMap<Object, Integer>();
		String[] words = str.split(" ");
		if(words.length != pattern.length()) {
			return false;
		}
		for(Integer i=0; i<words.length; i++) {
			if(map.put(pattern.charAt(i), i) != map.put(words[i], i)) {	
				System.out.println(map);
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		n290_Word_Pattern obj = new n290_Word_Pattern();
/*		System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
		System.out.println(obj.wordPattern("abba", "dog cat cat fish"));
		System.out.println(obj.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(obj.wordPattern("abba", "dog dog dog dog"));*/
		System.out.println(obj.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
, 		"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
));
		
/*		System.out.println(obj.wordPattern2("abba", "dog cat cat dog"));
		System.out.println(obj.wordPattern2("abba", "dog cat cat fish"));
		System.out.println(obj.wordPattern2("aaaa", "dog cat cat dog"));
		System.out.println(obj.wordPattern2("abba", "dog dog dog dog"));*/
		System.out.println(obj.wordPattern2("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
, 		"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
));
	}
}
