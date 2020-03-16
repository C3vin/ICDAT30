package LeetCode;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. 
The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number 
four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which 
is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
Input: "III"
Output: 3

Example 2:
Input: "IV"
Output: 4

Example 3:
Input: "IX"
Output: 9

Example 4:
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

public class n013_roman_to_integer {
	public int romanToInt(String s) {
		int[] transfer = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case 'M':
				transfer[i] = 1000;
				break;
			case 'D':
				transfer[i] = 500;
				break;
			case 'C':
				transfer[i] = 100;
				break;
			case 'L':
				transfer[i] = 50;
				break;
			case 'X':
				transfer[i] = 10;
				break;
			case 'V':
				transfer[i] = 5;
				break;
			case 'I':
				transfer[i] = 1;
				break;
			}
		}

		int sum = 0;
		for(int i=0; i<transfer.length-1; i++) {	 	//transfer.length-1, for the return
			if(transfer[i] < transfer[i+1])
				sum = sum - transfer[i];				//why? e.g. IV, sum = 0 - 1 = -1. when return will do (-1) + last (5) = 4
			else {
				sum = sum + transfer[i];
			}
			System.out.println(sum);
		}
		return sum + transfer[transfer.length-1]; 		//F: need to add last value, because we use 0 ~ transfer.length-1
	}
	
	public int romanToInt2(String s) {
		int[] num = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case 'M':
				num[i] = 1000;
				break;
			case 'D':
				num[i] = 500;
				break;
			case 'C':
				num[i] = 100;
				break;
			case 'L':
				num[i] = 50;
				break;
			case 'X':
				num[i] = 10;
				break;
			case 'V':
				num[i] = 5;
				break;
			case 'I':
				num[i] = 1;
				break;
			}
		}
		int res = num[0];
		for(int i=1; i<num.length; i++) {	           //start with 1
			if(num[i] > num[i-1]) {
				res = res + num[i] - 2 * num[i-1];				
			} else {
				res = res + num[i];	
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		n013_roman_to_integer obj = new n013_roman_to_integer();
		System.out.println(obj.romanToInt("VI"));
		System.out.println(obj.romanToInt("CV"));
		System.out.println(obj.romanToInt("IV"));
		System.out.println(obj.romanToInt("MCMXCIV"));
		
		System.out.println(obj.romanToInt2("VI"));
		System.out.println(obj.romanToInt2("CV"));
		System.out.println(obj.romanToInt2("IV"));
		System.out.println(obj.romanToInt2("MCMXCIV"));
	}
}
