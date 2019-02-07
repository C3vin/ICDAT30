package LeetCode;

import java.util.HashMap;

/*
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, 
and all the 0's and all the 1's in these substrings are grouped consecutively.
Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 */
public class n696_Count_Binary_Substrings {
	public int countBinarySubstrings(String s) {
		//prev: previous 0 number, curr: current 1 number
		int prev = 0;
		int curr = 1;
		int count = 0;

		for(int i=1; i<s.length(); i++) {
			//handle 11, 00
			if(s.charAt(i) == s.charAt(i-1)) {
				curr++;
			} else {
				prev = curr;
				curr = 1;		//reset
			}
			if(prev >= curr) {
				count++;
			}
		}
		return count;
	}
	
	public int countBinarySubstrings2(String s) {
		int one = 0;
		int zero = 0;
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(i == 0) {
				boolean c = (s.charAt(i) == 0);
				System.out.println(c);
			} else {
				if(s.charAt(i) == 1) {
					
				} else {
					
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		n696_Count_Binary_Substrings obj = new n696_Count_Binary_Substrings();
		System.out.println(obj.countBinarySubstrings("00110011"));
		System.out.println(obj.countBinarySubstrings("10101"));
		System.out.println(obj.countBinarySubstrings2("00110011"));
		System.out.println(obj.countBinarySubstrings2("10101"));
	}
}
