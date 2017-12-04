package LeetCode;

//Implement int sqrt(int x).
//Compute and return the square root of x.
//x is guaranteed to be a non-negative integer.
//Input: 4 => Output: 2
//Input: 8 => Output: 2
public class n069_Sqrt {
	//in LC, need to use long to handle big number
	public int mySqrt(int x) {
		int low = 0;
		int hight = x;

		while(low <= hight) {
			int mid = (low+hight)/2;

			if(mid*mid < x) {
				low = mid+1;
			} else if(mid*mid > x) {
				hight = mid-1;
			} else 
				return mid;
		}
		return hight;
	}
	public static void main(String[] args) {
		n069_Sqrt obj = new n069_Sqrt();
		System.out.println(obj.mySqrt(4));
		System.out.println(obj.mySqrt(8));
	}
}
