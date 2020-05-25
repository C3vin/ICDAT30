package INQ.ZOOM;

public class findMaximumLengthSubArrayHavingGivenSum {
/*
 * "Given an array of integers, find maximum length sub-array having given sum.
 * 
 * A[] = {5,6,-5,5,3,5,3,-2,0}
 * Sum = 8
 * 
 * sub array with 8 are
 * {-5,5,3,5}, {3,5}, {5,3}
 * The longest subarray is {-5,5,3,5} having length 4
 */
	public int maxLengthSubArray(int[] A, int S) {
		int len = 0;
		//int endIndex = -1;
		
		for(int i=0; i<A.length; i++) {
			int sum = 0;
			for(int j=i; j<A.length; j++) {
				sum = sum + A[j];
				
				if(sum == S) {
					len = Math.max(len, j-i+1);
					System.out.println(i + " : " + j);
			//		endIndex = j; 	//update
				}
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		findMaximumLengthSubArrayHavingGivenSum obj = new findMaximumLengthSubArrayHavingGivenSum();
		System.out.println(obj.maxLengthSubArray(new int[] {5,6,-5,5,3,5,3,-2,0}, 8));
		System.out.println(obj.maxLengthSubArray(new int[] {5,6,-5,5,3,5,3,-2,0}, 11));
	}
}
