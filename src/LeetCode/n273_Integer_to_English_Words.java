package LeetCode;

/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:
Input: 123
Output: "One Hundred Twenty Three"

Example 2:
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class n273_Integer_to_English_Words {
	private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	public String numberToWords(int num) {
		if(num == 0) {
			return "Zero";
		}
		return helper(num);
	}
	
	private String helper(int num) {
		String res = new String();
		if(num < 10) {
			res = belowTen[num];
		} else if(num < 20) {
			res = belowTwenty[num - 10];
		} else if(num < 100) {
			res = belowHundred[num / 10] + " " + helper(num % 10);
		} else if(num < 1000) {
			res = helper(num / 100) + " Hundred " + helper(num % 100);
		} else if(num < 1000000) {
			res = helper(num / 1000) + " Thousand " + helper(num % 1000);
		} else if(num < 1000000000) {
			res = helper(num / 1000000) + " Million " + helper(num % 1000000);
		} else {
			res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
		}
		return res.trim();
	}
	
	public static void main(String[] args) {
		n273_Integer_to_English_Words obj = new n273_Integer_to_English_Words();
		System.out.println(obj.numberToWords(123));
		System.out.println(obj.numberToWords(12345));
		System.out.println(obj.numberToWords(1234567));
		System.out.println(obj.numberToWords(1234567891));
	}
}
