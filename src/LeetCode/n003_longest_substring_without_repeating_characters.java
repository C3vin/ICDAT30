package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
//abcabcbb
//iiiiiiii
//ssss s s
public class n003_longest_substring_without_repeating_characters {
	
	//Good!!
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int start = 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i))+1);
            }    
            
            map.put(s.charAt(i), i);
            res = Math.max(res, i-start+1);
        }
        
        return res;
    }
	
	//Sliding Window, HashSet
	public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        
        int res = 0;
        int start = 0;
        int current = 0;
        
        while(start < s.length() && current < s.length()) {
            if(!set.contains(s.charAt(current))) {
                set.add(s.charAt(current));
                current++;
                res = Math.max(res, current - start);
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        
        return res;
 	}
	
	//Sliding Window, HashMap Better!  WK_Q1
	public int lengthOfLongestSubstring3(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();		//Character not String type

		int res = 0;
		int left = 0;
		int right = 0;
		
		while(right < s.length()) {						//no need (start < s.length() && 
			if(map.containsKey(s.charAt(right))) {
				//e.g. pwwkew
				//     s s    (0->2)
				left = Math.max(left, map.get(s.charAt(right))+1);	//update left, need to use 'Max' in case get wrong idx to first match char index e.g. "abba"
			} //no else !!!
			
			map.put(s.charAt(right), right);		                //either add or update value
			res = Math.max(res, right-left+1);
			
			right++;
		}
		
		return res;
	}
	public static void main(String[] args) {
		n003_longest_substring_without_repeating_characters obj = new n003_longest_substring_without_repeating_characters();
		System.out.println(obj.lengthOfLongestSubstring3("abba"));
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(obj.lengthOfLongestSubstring3("abcabcbb"));
		System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
		System.out.println(obj.lengthOfLongestSubstring3("bbbbb"));
		System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
		System.out.println(obj.lengthOfLongestSubstring3("pwwkew"));
	}
}
