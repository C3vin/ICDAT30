package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class n003_longest_substring_without_repeating_characters {
	//Brute Force
	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		for (int i=0; i<s.length(); i++)
			for (int j=i+1; j<s.length()-1; j++)		//j<=n
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j-i);		//?
				}
		return ans;
	}

	private boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<> ();
		for (int i=start; i<end; i++) {
			Character ch = s.charAt(i);		//?
			if (set.contains(ch)) 
				return false;
			set.add(ch);
		}
		return true;
	}

}
