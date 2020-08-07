package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class n054_Spiral_Matrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();

		int rb = 0;
		int re = matrix.length-1;
		int cb = 0;
		int ce = matrix[0].length-1;

		while(rb <= re && cb <= ce) {
			for(int i=cb; i<=ce; i++) {
				res.add(matrix[rb][i]);
			}
			rb++;

			for(int i=rb; i<=re; i++) {
				res.add(matrix[i][ce]);
			}
			ce--;

			if(rb <= re) {
				for(int i=ce; i>=cb; i--) {
					res.add(matrix[re][i]);
				}
				re--;
			}

			if(cb <= ce) {
				for(int i=re; i>=rb; i--) {
					res.add(matrix[i][cb]);
				}
				cb++;
			}
		}

		return res;
	}
	public static void main(String[] args) {
		n054_Spiral_Matrix obj = new n054_Spiral_Matrix();
		int[][] matrix = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		System.out.println(obj.spiralOrder(matrix));
		int[][] matrix2 = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9},
			{10,11,12}
		};
		System.out.println(obj.spiralOrder(matrix2));
		int[][] matrix3 = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		System.out.println(obj.spiralOrder(matrix3));
	}
}
