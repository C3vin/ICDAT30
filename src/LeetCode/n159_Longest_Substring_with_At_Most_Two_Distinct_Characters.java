package LeetCode;

import java.util.HashMap;

//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//For example, Given s = “eceba”,
//T is "ece" which its length is 3.

public class n159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		int i = 0;
		int j = 0;
		int n = s.length();
		int maxLen = 0;
		
		while(i<n && j<n) {
			if(!map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j), 1);
			} else {
				map.put(s.charAt(j), map.get(s.charAt(j))+1);
			}
			if(map.get(s.charAt(j)) == 1)			//new value
				count++;
			j++;
				
			if(count > 2) {							//e.g. count = 3, meaning 3 distinct char, need to sliding window  
				map.put(s.charAt(i), map.get(s.charAt(i))-1);
				if(map.get(s.charAt(i)) == 0)		//eceb, after -1, map[(e,1), (c,0), (b,1)] so count--;
					count--;
				i++;
			}
			maxLen = Math.max(maxLen, j-i);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		n159_Longest_Substring_with_At_Most_Two_Distinct_Characters obj = new n159_Longest_Substring_with_At_Most_Two_Distinct_Characters();
		String s = "ecebaa";
		//String s = "abcabcabc";	//2 
		System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
	}
}
