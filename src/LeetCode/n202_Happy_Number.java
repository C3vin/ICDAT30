package LeetCode;

import java.util.HashSet;

/*
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Example 2:
Input: n = 2
Output: false
 */
public class n202_Happy_Number {
	//Detect Cycles with a HashSet Sol
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(n != 1 && !set.contains(n)) {			//need 'while' not if !!!
			set.add(n);
			n = getNext(n);
		}
		
		return n == 1;
	}
	
	private int getNext(int n) {
		int sum = 0;
		
		while(n > 0) {								//need 'while' to check all n
			int d = n % 10;
			n = n / 10;
			
			sum = sum + d * d;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		n202_Happy_Number obj = new n202_Happy_Number();
		System.out.println(obj.isHappy(19));
		System.out.println(obj.isHappy(2));
	}
}
