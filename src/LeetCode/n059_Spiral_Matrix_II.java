package LeetCode;

/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class n059_Spiral_Matrix_II {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		
		int rb = 0;
		int re = n-1;
		int cb = 0;
		int ce = n-1;
		int num = 1;
		
		while(rb <= re && cb <= ce) {
			for(int i=cb; i<=ce; i++) {
				matrix[rb][i] = num++;
			}
			rb++;
			
			for(int i=rb; i<re; i++) {
				matrix[i][ce] = num++;
			}
			ce--;
			
			for(int i=ce; i>=cb; i--) {
				matrix[re][i] = num++;
			}
			re--;
			
			for(int i=re; i>=rb; i--) {
				matrix[i][cb] = num++;
			}
			cb++;
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		n059_Spiral_Matrix_II obj = new n059_Spiral_Matrix_II();
		System.out.println(obj.generateMatrix(3));
	}
}
