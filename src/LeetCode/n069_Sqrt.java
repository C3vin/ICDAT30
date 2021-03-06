package LeetCode;

/*
Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
 */
public class n069_Sqrt {
	//in LC, need to use long to handle big number
	public int mySqrt(int x) {
		int left = 0;
		int right = x;
		
		while(left <= right) {
			long mid = left + (right-left)/2;		//use long to handle case 2147395599
			
			if(mid*mid == x) {
				return (int)mid;
			} else if(mid*mid < x){					// x not right
				left = (int)mid+1;					//need covert (int)!
			} else {
				right = (int)mid-1;					//need covert (int)!	
			}
		}

		return (int)right;					//right e.g. 8 //need covert (int)!
	}
	
	public static void main(String[] args) {
		n069_Sqrt obj = new n069_Sqrt();
		System.out.println(obj.mySqrt(4));
		System.out.println(obj.mySqrt(8));
		System.out.println(obj.mySqrt(2147395599));
	}
}
