package LeetCode;

public class n50_Pow {
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
    	n50_Pow obj = new n50_Pow();
    	System.out.println(obj.myPow(2, 4));
    	System.out.println(obj.myPow(2, 5));
    }
}
