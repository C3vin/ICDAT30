package LeetCode;

import java.util.HashMap;

public class n003_longest_substring_without_repeating_characters {
	//Brute Force
	/*	public int lengthOfLongestSubstring(String s) {
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
	}*/
	
	public int lengthOfLongestSubstring(String s) {
		if (s.length()==0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//i = current point, j = start point (non repeating) 
		int max=0;
		int start=0;  
		for (int current = 0; current<s.length(); current++) {
			if (map.containsKey(s.charAt(current))) {
				start = Math.max(start, map.get(s.charAt(current)) + 1);		//Need + 1
			}
			map.put(s.charAt(current), current);
			max = Math.max(max, current - start + 1);
		}
		return max;
	}
	public static void main(String[] args) {
		n003_longest_substring_without_repeating_characters obj = new n003_longest_substring_without_repeating_characters();
		String s = "abcabcbb";
		System.out.println(obj.lengthOfLongestSubstring(s));
	}
}
