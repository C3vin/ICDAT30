package LeetCode;

import java.util.Arrays;

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
		
		//System.out.println(sch);
		//System.out.println(tch);
		
		if(Arrays.equals(sch, tch))		//compare two char array using Arrays.equals.
			return true;
		
		return false;
	}
	public static void main(String[] args) {
		n242_Valid_Anagram obj = new n242_Valid_Anagram();
		String s = "anagram"; 
		String t = "nagaram";
		//System.out.println(obj.isAnagram(s, t));
		System.out.println(obj.isAnagram2(s, t));
	}
}
