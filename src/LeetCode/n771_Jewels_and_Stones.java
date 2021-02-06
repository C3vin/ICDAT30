package LeetCode;

import java.util.HashSet;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 */
public class n771_Jewels_and_Stones {
	public int numJewelsInStones(String jewels, String stones) {
		int res = 0;
		HashSet<Character> set = new HashSet<Character>();	//also can use HashMap
		
		for(char j : jewels.toCharArray()) {
			set.add(j);
		}
		
		for(char s : stones.toCharArray()) {
			if(set.contains(s)) {
				res = res + 1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		n771_Jewels_and_Stones obj = new n771_Jewels_and_Stones();
		System.out.println(obj.numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(obj.numJewelsInStones("z", "ZZ"));
	}
}
