package LeetCode;

import java.util.HashMap;

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */

public class n383_Ransom_Note {
	//sol1
	public boolean canConstruct(String ransomNote, String magazine) {
		byte[] b = new byte[magazine.length()];
		boolean ret = true;

		for(int i=0; i<ransomNote.length(); i++) {
			boolean found = false;
			char c = ransomNote.charAt(i);
			for(int j=0; j<magazine.length(); j++) {
				if(b[j] == 0 && magazine.charAt(j) == c) {
					b[j]++; 
					found = true;
					break;							//break the for loop, go to next if loop
				}
			}
			if(!found) {
				ret = false;
				break;								//use this 'break' can save the time, cuz not find in the magazine
			}
		}
		return ret;
	}
	//sol2 best sol
	public boolean canConstruct2(String ransomNote, String magazine) {
		int[] alph = new int[26];
		for(int i=0; i<magazine.length(); i++) {
			 alph[magazine.charAt(i)-'a']++;
		}
		for(int j=0; j<ransomNote.length(); j++) {
			if(--alph[ransomNote.charAt(j)-'a'] < 0)		//F: --first
				return false;
		}
		return true;
	}
	
	//sol3 Hashmap new!
	public boolean canConstruct3(String ransomNote, String magazine) {
		if(ransomNote.length() > magazine.length()) {
			return false;
		}
		if(ransomNote.isEmpty() && magazine.isEmpty()) {
			return true;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();		
		
		for(char c : ransomNote.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		
		for(char c : magazine.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)-1);			//minus one
				if(map.get(c) == 0) {				
					map.remove(c);					//need to remove key for KeySet size
				}
			} 
			if(map.keySet().size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n383_Ransom_Note obj = new n383_Ransom_Note();
		System.out.println(obj.canConstruct("aa", "aab"));	//true
		System.out.println(obj.canConstruct("aa", "ab"));	//false
		System.out.println(obj.canConstruct2("aa", "aab"));	//true
		System.out.println(obj.canConstruct2("aa", "ab"));	//false
		System.out.println(obj.canConstruct3("aa", "aab"));	//true
		System.out.println(obj.canConstruct3("aa", "ab"));	//false
	}
}
