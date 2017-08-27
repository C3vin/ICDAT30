package LeetCode;

import java.util.Arrays;
//For example, s = "anagram", t = "nagaram", return true.
//Follow up:What if the inputs contain unicode characters? How would you adapt your solution to such case?

public class n242_Valid_Anagram {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;

		int[] list = new int[26];
		for(int i=0; i<s.length(); i++) {
			list[s.charAt(i) - 'a']++;
			list[t.charAt(i) - 'a']--;

		}
		for(int i: list) {
			if(i!=0)
				return false;
		}
		return true;
	}

	//sort and compare
	public boolean isAnagram2(String s, String t) {
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();
		Arrays.sort(sch);				//F: if sort, need to convert to char array first.
		Arrays.sort(tch);
		
		if(Arrays.equals(sch, tch))		//compare two char array using Arrays.equals.
			return true;
		
		//if don't want to use Arrays.equals()
/*		for(int i=0; i<s.length(); i++) {
			if(sch[i] != tch[i])
				return false;
		}*/
		
		return false;
	}
	public static void main(String[] args) {
		n242_Valid_Anagram obj = new n242_Valid_Anagram();
		String s = "#anagram@"; 
		String t = "n#agar@am";
		//System.out.println(obj.isAnagram(s, t));		//can't handle unicode
		System.out.println(obj.isAnagram2(s, t));		//OK for unicode
	}
}
