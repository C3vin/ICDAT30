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
	//Good! https://leetcode.com/problems/spiral-matrix/discuss/20599/Super-Simple-and-Easy-to-Understand-Solution/20805
	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		
		int rowU = 0;
		int rowD = matrix.length-1;
		int colL = 0;
		int colR = matrix[0].length-1;
		
		while(rowU <= rowD && colL <= colR) {
			for(int i=colL; i<=colR; i++) {
				res.add(matrix[rowU][i]);
			}
			rowU++;
			
			for(int i=rowU; i<=rowD; i++) {
				res.add(matrix[i][colR]);
			}
			colR--;
			
			if(rowU <= rowD) {
				for(int i=colR; i>=colL; i--) {
					res.add(matrix[rowD][i]);
				}
			}
			rowD--;
			
			if(colL <= colR) {
				for(int i=rowD; i>=rowU; i--) {
					res.add(matrix[i][colL]);
				}
			}
			colL++;
		}
		
		return res;
	}
	
	//Good!for follow up question 
	public List<Integer> spiralOrder3(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		
		int rowU = 0;
		int rowD = matrix.length-1;
		int colL = 0;
		int colR = matrix[0].length-1;
		
		while(rowU <= rowD && colL <= colR) {
			for(int i=colL; i<=colR; i++) {
				if(checkPrime(matrix[rowU][i]))
				res.add(matrix[rowU][i]);
			}
			rowU++;
			
			for(int i=rowU; i<=rowD; i++) {
				if(checkPrime(matrix[i][colR]))
				res.add(matrix[i][colR]);
			}
			colR--;
			
			if(rowU <= rowD) {
				for(int i=colR; i>=colL; i--) {
					if(checkPrime(matrix[rowD][i]))
					res.add(matrix[rowD][i]);
				}
			}
			rowD--;
			
			if(colL <= colR) {
				for(int i=rowD; i>=rowU; i--) {
					if(checkPrime(matrix[i][colL]))
					res.add(matrix[i][colL]);
				}
			}
			colL++;
		}
		
		return res;
	}
	//follow up: print only 'Prime' number. res: https://www.programiz.com/java-programming/examples/prime-number
	private boolean checkPrime(int num) {
		if(num == 1) {
			return false;
		}
		
		int remainder;
		//we are looping from 2 to num/2. It is because a number is not divisible by more than its half.
        for (int i=2; i<=num/2; i++) {
            remainder = num % i;
            //if remainder is 0 than num is a prime and break loop. Else continue loop
            if (remainder == 0) {
                return false;
            }
        }
        return true;
	}
	
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
//		int[][] mmatrix = new int[][] {
//			{1,2,3},
//			{4,5,6},
//			{7,8,9}
//		};
//		System.out.println(obj.spiralOrder2(mmatrix));
//		int[][] mmatrix2 = new int[][] {
//			{1,2,3},
//			{4,5,6},
//			{7,8,9},
//			{10,11,12}
//		};
//		System.out.println(obj.spiralOrder2(mmatrix2));
		int[][] mmatrix3 = new int[][] {
			{7,7,3,8,1},
			{13,5,4,5,2},
			{9,2,12,3,9},
			{6,12,1,11,41}
		};
		System.out.println(obj.spiralOrder2(mmatrix3));
		
		int[][] mmatrix4 = new int[][] {
			{7,7,3,8,1},
			{13,5,4,5,2},
			{9,2,12,3,9},
			{6,12,1,11,41}
		};
		System.out.println(obj.spiralOrder3(mmatrix4));
		
//		int[][] matrix = new int[][] {
//			{1,2,3},
//			{4,5,6},
//			{7,8,9}
//		};
//		
//		System.out.println(obj.spiralOrder(matrix));
//		int[][] matrix2 = new int[][] {
//			{1,2,3},
//			{4,5,6},
//			{7,8,9},
//			{10,11,12}
//		};
//		System.out.println(obj.spiralOrder(matrix2));
//		int[][] matrix3 = new int[][] {
//			{1,2,3,4},
//			{5,6,7,8},
//			{9,10,11,12}
//		};
//		System.out.println(obj.spiralOrder(matrix3));
	}
}
