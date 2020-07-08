package LeetCode;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
 */
public class n007_reverse_interger {
	public int reverseInterger(int x) {
        long res = 0;				//must use long to handle larger num
        
        while (x != 0) {			//while !!!
            res = res * 10 + x % 10;
            x = x / 10;
            
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            	return 0;
            }
        }
        return (int)res;		//convert
	}
	public static void main(String[] args) {
		n007_reverse_interger obj = new n007_reverse_interger();
		int x = -123;		//Integer.MAX_VALUE;
		System.out.println(x + " : "+ obj.reverseInterger(x));
	}
}
