package LeetCode;

import java.util.Arrays;

public class n977_Squares_of_a_Sorted_Array {
	public int[] sortedSquares(int[] A) {
		int[] res = new int[A.length];

		for(int i=0; i<A.length; i++) {
			res[i] = A[i] * A[i];
		}

		Arrays.sort(res);

		return res;
	}

	public int[] sortedSquares2(int[] A) {
		int[] res = new int[A.length];
		int left = 0;
		int right = A.length-1;


		for(int i=A.length-1; i>=0; i--) {					//no need to check the left<right for case [1]
			if(Math.abs(A[left]) > Math.abs(A[right])) {
				res[i] = A[left] * A[left];
				left++;
			} else {
				res[i] = A[right] * A[right];
				right--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		n977_Squares_of_a_Sorted_Array obj = new n977_Squares_of_a_Sorted_Array();
		System.out.println(obj.sortedSquares(new int[] {-4,-1,0,3,10}));
		System.out.println(obj.sortedSquares(new int[] {-7,-3,2,3,11}));

		System.out.println(obj.sortedSquares2(new int[] {1}));
		System.out.println(obj.sortedSquares2(new int[] {-4,-1,0,3,10}));
		System.out.println(obj.sortedSquares2(new int[] {-7,-3,2,3,11}));
	}
}
