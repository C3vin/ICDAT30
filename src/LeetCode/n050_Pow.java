package LeetCode;

/*
Implement pow(x, n), which calculates x raised to the power n (x^n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25

Note:
-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [-2^31, 2^31-1]
 */
public class n050_Pow {
    //Good!
	/* x = 2 n = 1 | half = 1
	 *     2     2          2
	 *     2	 5          4
	 *     2    10         32
	 */
    public double myPow2(double x, int n) {
    	if(n == 0) {
    		return 1;
    	}
    	
    	double half = myPow2(x, n/2);
    	
    	if(n%2 == 0) {
    		return half*half;
    	}
    	
    	if(n > 0) {
    		return half*half*x;
    	}
    	
    	return half*half/x;				//handle n is negative
    }
	
    public double myPow(double x, int n) {
    	//x^n = x^(n/2) * x^(n/2) * x^(n%2)
    	if(x == 0.0 || x == 1.0) return x;
    	if(n == 0) 
    		return 1;
    	else if (n < 0) {
    	     // special case for MIN_VALUE since -MIN_VALUE = MAX_VALUE+1			//???
            if (n == Integer.MIN_VALUE)
                return myPow(x, n+1)/x;
            else 
                return 1.0/myPow(x, -n);
    	}
    	else if (n == 1) 
    		return x;
    	else if (n % 2 == 0) { //even
    		double res = myPow(x, n/2);
    		return res*res;
    	} else {
    		double res = myPow(x, n/2);
    		return res*res*x;
    	}
    }
    
    public static void main(String[] args) {
    	n050_Pow obj = new n050_Pow();
//    	System.out.println(obj.myPow(2, 4));
//    	System.out.println(obj.myPow(2, 5));
//    	System.out.println(obj.myPow2(2, 4));
//    	System.out.println(obj.myPow2(2, 5));
//    	System.out.println(obj.myPow2(2.10000, 3));
//    	System.out.println(obj.myPow2(3.00000, 2));
//    	System.out.println(obj.myPow2(2.00000, 10));
    	System.out.println(obj.myPow2(2.00000, -2));
    }
}
