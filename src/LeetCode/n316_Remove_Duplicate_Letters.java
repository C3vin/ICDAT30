package LeetCode;

import java.util.HashMap;

/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: "bcabc"
Output: "abc"

Example 2:
Input: "cbacdcbc"
Output: "acdb"
 */
public class n316_Remove_Duplicate_Letters {
	public String removeDuplicateLetters(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		
		char[] res = new char[map.size()];
		int start = 0; 
		int end = findMinLastPos(map);
		for(int i=0; i<res.length; i++) {
			char minChar = 'z' + 1;							//reset minChar -> {
			for(int j=start; j<=end; j++) {
				if(map.containsKey(s.charAt(j)) && s.charAt(j) < minChar) {
					minChar = s.charAt(j);					//update minChar
					start = j + 1;							//need this! for next start index
				}
			}
			res[i] = minChar;
			map.remove(minChar);
			
			if(s.charAt(end) == minChar) {					//update end
				end = findMinLastPos(map);
			}
		}
		return new String(res);
	}
	private int findMinLastPos(HashMap<Character, Integer> map) {
		int min = Integer.MAX_VALUE;
		for(int num : map.values()) {
			min = Math.min(min, num);
		}
		return min;
	}
	
	public static void main(String[] args) {
		n316_Remove_Duplicate_Letters obj = new n316_Remove_Duplicate_Letters();
		System.out.println(obj.removeDuplicateLetters("baabc"));
		System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
	}
}
