package LeetCode;

/*
Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class n066_Plus_One {
	public int[] plusOne2(int[] digits) {
		for(int i=digits.length-1; i>=0; i--) {
			digits[i] = digits[i]+1;
			if(digits[i] == 10) {
				digits[i] = 0;
			} else 
				return digits;
		}
		int[] newdigits = new int[digits.length+1];
		newdigits[0] = 1;
		for(int i=1; i<digits.length; i++) {
			newdigits[i] = digits[i-1];
		}
		return newdigits;
	}
	
	//cs
	public int[] plusOne3(int[] digits) {
		for(int i=digits.length-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		
		int[] res = new int[digits.length+1];
		res[0] = 1;
		
		return res;
	}
	
	public static void main(String[] args) {
		n066_Plus_One obj = new n066_Plus_One();
		int[] digits = {9,9};
		System.out.println(obj.plusOne2(digits));
		System.out.println(obj.plusOne3(new int[] {1,2,3}));
		System.out.println(obj.plusOne3(new int[] {4,3,2,1}));
		System.out.println(obj.plusOne3(new int[] {9,9}));
		System.out.println(obj.plusOne3(new int[] {1,9}));
	}
}
