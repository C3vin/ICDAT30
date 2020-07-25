package LeetCode;

/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class n048_Rotate_Image {
	//Same as ctci 1.7
	//Need one int array, cope orig to new, then copy back to orig
	public void rotate(int[][] matrix) {
		int m = matrix.length;  			//row   -> 
		int n = matrix[0].length;			//col    ^
		int[][] result = new int[m][n];

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				result[j][n-1-i] = matrix[i][j];		//(0,0) -> (0,2)
			}
		}

		for(int i=0; i<m; i++) {			//copy back
			for(int j=0; j<n; j++) {
				matrix[i][j] = result[i][j];
			}
		}

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
	}

	//sol: In place
	public void rotate2(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		/***
		 *  i: 0 j: 0
			i: 0 j: 1
			i: 0 j: 2
			i: 1 j: 0
			i: 1 j: 1
			i: 1 j: 2
		 */
		/*for(int i=0; i<m/2; i++) {					//2 loop
			for(int j=0; j<(m+1)/2; j++) {			//4 sides
				System.out.println(i+" : "+j);
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[m-1-j][i];
				matrix[m-1-j][i] = matrix[m-1-i][m-1-j];
				matrix[m-1-i][m-1-j] = matrix[j][m-1-i];
				matrix[j][m-1-i] = tmp;
			}
		}*/
		
		//https://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degrees-inplace.html
		int length = matrix.length-1;
		
		for (int i = 0; i <= (length)/2; i++) {
			for (int j = i; j < length-i; j++) {
				//System.out.println(i+" : "+j);
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[length-j][i];
				matrix[length-j][i] = matrix[length-i][length-j];
				matrix[length-i][length-j] = matrix[j][length-i];
				matrix[j][length-i] = tmp;
			}
		}

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j]);
			}System.out.print("\n");
		}
	}

	public static void main(String[] args) {  
		n048_Rotate_Image obj = new n048_Rotate_Image();

		int[][] matrix = 
				   {{1, 2, 3, 4, 5},
					{6, 7, 8, 9, 10},
					{11,12,13,14,15},
					{16,17,18,19,20},
					{21,22,23,24,25}};

		/*			   {{1,2,0,4,5},
				{1,2,3,0,6},
				{1,0,0,4,6},
				{1,2,0,4,5},
				{1,2,3,4,6}};*/

		obj.rotate2(matrix);
		System.out.println("");

		//		obj.rotate(new int[][] 
		//			{{1,2,3},
		//			{4,5,6},
		//			{7,8,9},});

		System.out.println("");

		int[][] matrix1 = 
					{{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16}};

		/* {{1,2,3},
				{4,5,6},
				{7,8,9},
				};*/
		//obj.rotate2(matrix1);
	}
}
