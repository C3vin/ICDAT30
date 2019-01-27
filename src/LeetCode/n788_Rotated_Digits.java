package LeetCode;

/*
X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 */
public class n788_Rotated_Digits {
	public int rotatedDigits(int N) {
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(isValid(i)){
				count++;
			}
		}
		return count;
	}
	private boolean isValid(int n) {
		boolean valid = false;
		
		while(n > 0) {
			//digit need to in while loop
			int digit = n % 10;			//why need digit, cuz only need to check digit valid! 
			if(digit == 3 || digit == 4 || digit == 7) {
				return false;
			}
			if(digit == 2 || digit == 5 || digit == 6 || digit == 9) {
				valid = true;
			}
			n = n / 10; 
		}
		return valid;
	}
	public static void main(String[] args) {
		n788_Rotated_Digits obj = new n788_Rotated_Digits();
		System.out.println(obj.rotatedDigits(857));
	}
}
