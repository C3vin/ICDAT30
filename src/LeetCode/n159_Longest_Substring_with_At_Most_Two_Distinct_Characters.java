package LeetCode;

import java.util.HashMap;

//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//For example, Given s = “eceba”,
//T is "ece" which its length is 3.

public class n159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int res = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int start = 0;
		for(int i=0; i<s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
			
			if(map.size() > 2) {
				map.put(s.charAt(start), map.get(s.charAt(start))-1);
				
				if(map.get(s.charAt(start)) == 0) {
					map.remove(s.charAt(start));
				}
				
				start++;
			}
			
			res = Math.max(res, i-start+1);
		}
		
		return res;
	}

	public int lengthOfLongestSubstringTwoDistinct2(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int left = 0; // start of the window
		int right = 0; // end of the window
		int res = 0;

		while(right < s.length()) {
			if(map.size() <= 2) {  
				// add new charater from the end pointer
				map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1); // increase the counter if we face this character
				right++;

			} else {

				map.put(s.charAt(left), map.get(s.charAt(left))-1);

				if(map.get(s.charAt(left)) < 1) {
					map.remove(s.charAt(left));
				}

				//				// decrease the size of the window as far as we've reached the number of distinct characters at most two
				//				// remove start character
				//				int counter = map.get(s.charAt(left)) - 1;
				//				if(counter < 1) {
				//					// there are no such characters in a row. Let's delete the character from the map
				//					map.remove(s.charAt(left));
				//				} else {
				//					// update counter
				//					map.put(s.charAt(left), counter);
				//				}

				left++;
			}

			// if we still in the right amount of distinct characters calculate maximus
			if(map.size() <= 2) {  
				res = Math.max(res, (right - left) + 0);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		n159_Longest_Substring_with_At_Most_Two_Distinct_Characters obj = new n159_Longest_Substring_with_At_Most_Two_Distinct_Characters();
		//String s = "abcabcabc";	//2 
		System.out.println(obj.lengthOfLongestSubstringTwoDistinct("eceba"));

		System.out.println(obj.lengthOfLongestSubstringTwoDistinct(
				"ccaabbb"));
		System.out.println(obj.lengthOfLongestSubstringTwoDistinct2("eceba"));
	}
}
