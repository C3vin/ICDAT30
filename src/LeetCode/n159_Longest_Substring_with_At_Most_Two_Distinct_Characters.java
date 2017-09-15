package LeetCode;

import java.util.HashMap;

//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//For example, Given s = “eceba”,
//T is "ece" which its length is 3.

public class n159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int res = 0;
		int n = s.length();
		int i = 0;
		int j = 0;
		int count = 0;
		while(i < n && j < n) {
			if(map.containsKey(s.charAt(j))) {
				count++;
				if(count == 1) {
					System.out.println("i: "+i + " j: "+ j);
					res = Math.max(res, j-i+1);
					i = Math.max(map.get(s.charAt(j)), i);		//update i;
					System.out.println("i: "+i + " j: "+ j + " res: " + res);
					count--;
				}
			}
			map.put(s.charAt(j), j+1);
			j++;
			System.out.println(map);
		}
		return res;
	}
	public static void main(String[] args) {
		n159_Longest_Substring_with_At_Most_Two_Distinct_Characters obj = new n159_Longest_Substring_with_At_Most_Two_Distinct_Characters();
		String s = "ecebaab";
		System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
	}
}
