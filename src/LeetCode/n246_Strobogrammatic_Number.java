package LeetCode;

import java.util.HashMap;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:
Input:  "69"
Output: true

Example 2:
Input:  "88"
Output: true

Example 3:
Input:  "962"
Output: false
 */
public class n246_Strobogrammatic_Number {
	//hashmap
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		map.put('1', '1');
		map.put('0', '0');

		int l = 0;
		int r = num.length()-1;
		while(l <= r) {
			if(!map.containsKey(num.charAt(l))) {
				System.out.println(num);
				return false;
			}
			if(map.get(num.charAt(l)) != num.charAt(r)) {		//compare value and right num char
				System.out.println(l + " : "+ r);
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	public static void main(String[] args) {
		n246_Strobogrammatic_Number obj = new n246_Strobogrammatic_Number();
		System.out.println(obj.isStrobogrammatic("81818"));
		System.out.println(obj.isStrobogrammatic("69"));
		System.out.println(obj.isStrobogrammatic("88"));
		System.out.println(obj.isStrobogrammatic("962"));
	}
}
