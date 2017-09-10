package LeetCode;

/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string.
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
*/

public class n567_Permutation_in_String {
	public boolean checkInclusion(String s1, String s2) {
		int[] target = new int[256];

		for(int i=0; i<s1.length(); i++) {
			target[s1.charAt(i)]++;
		}

		int left = 0;
		int right = 0;
		int count = s1.length();
		while(right < s2.length()) {
			if(target[s2.charAt(right)] >= 1)
				count--;
			target[s2.charAt(right)]--;
			right++;

			if(count == 0)
				return true;

			if(right - left == s1.length()) {
				if(target[s2.charAt(left)] >= 0)		//>=0, not <=0. Because before at least 1
					count++;

				target[s2.charAt(left)]++;
				left++;
			}
		}
		return false;
	}
	//Sliding Window Space complexity : O(1) s1map, s2map size 26 is used.
	public boolean checkInclusion2(String s1, String s2) {
		if(s1.length() > s2.length()) 
			return false;

		int[] s1map = new int[26]; 	//index
		int[] s2map = new int[26];

		for(int i=0; i<s1.length(); i++) {
			s1map[s1.charAt(i) - 'a']++;
			s2map[s2.charAt(i) - 'a']++;			//need s2, first window
		}
		for(int i=0; i<s2.length()-s1.length(); i++) {
			if(isMatch(s1map, s2map))
				return true;
			//slide window, update s2map
			s2map[s2.charAt(i+s1.length()) - 'a']++;
			s2map[s2.charAt(i) - 'a']--;
		}
		return isMatch(s1map, s2map);
	}
	private boolean isMatch(int[] s1map, int[]s2map) {
		for (int i = 0; i < 26; i++) {
			if (s1map[i] != s2map[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		n567_Permutation_in_String obj = new n567_Permutation_in_String();
		String s1 = "abw";
		String s2 = "eidbaooo";
		System.out.println(obj.checkInclusion(s1, s2));
		System.out.println(obj.checkInclusion2(s1, s2));
	}
}
