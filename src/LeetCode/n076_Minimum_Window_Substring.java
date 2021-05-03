package LeetCode;

import java.util.HashMap;
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class n076_Minimum_Window_Substring {
	public String minWindow(String s, String t) {
		String res = "";
		if(s == null || t == null || s.length() == 0 || t.length() == 0) {
			return res;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i=0; i<t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);			//default is 1 e.g. {A=1, B=1, C=1}
		}
 
		int count = 0;
		int start = 0;					//same as LC 3 start index
		int minLen = Integer.MAX_VALUE;
		
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))-1);			//@step1
				
				//mean [A=1, B=-1, C=0] if two B in start -> i, so can't count++
				if(map.get(s.charAt(i)) >= 0) {					// >= 0 not just >  !, avoid count too much when @step1 
					count++;
				}

				//while not if  !!!!!!!!!!!!!!!!!!!!!!!!!!!!
				while(count == t.length()) {			
					if(map.containsKey(s.charAt(start))) {		//Need this check to avoid irrelevant char !!!!!!!!!!!!!
						map.put(s.charAt(start), map.get(s.charAt(start))+1);

						//why? cuz between start and i idx might include two char e.g. [BECODEBA] need to pass first B, until B val > 1
						if(map.get(s.charAt(start)) > 0) {		//why? cuz we count too much at @step1, so only accept > 0 for valid case
							if(minLen > i-start+1) {			// > !!!
								res = s.substring(start, i+1);
								minLen = i-start+1;
							} 
							
							//why? count--, cuz next will move start++ change window index
							count--;							//must in this loop, cuz match map.get(s.charAt(start)) > 0
						} 
					} 
					
					start++;
				} 
			}
		}
		
		return res;
	}
	
	//better and faster, Sliding Window! same as 438
	public String minWindow2(String s, String t) {
		String res = "";
		int[] target = new int[128];
		//int[] target = new int[26];		//can't use size 26, because we don't know low case or high case! 
		//record each character in t to target
		/*for(int i=0; i<t.length(); i++) {
			target[t.charAt(i)]++;
		}*/
		for(char c : t.toCharArray()) {
			target[c]++;
		}
		
		int left = 0;
		int right = 0;
		int count = t.length();			//window size
		int minlen = Integer.MAX_VALUE;

		while(right < s.length() || count == 0) {		//F: need count == 0, because first got 'ADOBEC'(count=0) but need keep searching 
			if(count == 0) {
				if(minlen > right - left) {				//because right already out of select window, 0123456, l(0)r(6), 6-0 = select window size
					minlen = right - left;				//update minlen
					res = s.substring(left, right);		//update string res, reference
				}
				
				if(target[s.charAt(left)] >= 0) {		//>=0, not <=0. Because before at least 1 (find the String t values)
					count++;
				}
				
				target[s.charAt(left)]++;
				left++;
			} else {
				if(target[s.charAt(right)] >= 1) {		//found it
					count--;
				}
				
				target[s.charAt(right)]--;
				right++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n076_Minimum_Window_Substring obj = new n076_Minimum_Window_Substring();
		System.out.println(obj.minWindow("ADBECBANC", "ABCC"));		//CBANC good example
		
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
		//System.out.println(obj.minWindow2("ADOBECODEBANC", "ABC"));
	}
}
