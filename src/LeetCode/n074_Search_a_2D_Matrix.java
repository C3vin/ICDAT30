package LeetCode;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class n074_Search_a_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		
        if(rows == 0) {             //must before cols, avoid OutOfBound Exception
			return false;
		}
        
		int cols = matrix[0].length;
		
		int left = 0;
		int right = rows*cols -1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			
			if(matrix[mid/cols][mid%cols] == target) {
				return true;
			} else if(matrix[mid/cols][mid%cols] < target) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		n074_Search_a_2D_Matrix obj = new n074_Search_a_2D_Matrix();
		System.out.println(obj.searchMatrix(new int[][] {
			{1,3,5,7},
			{10,11,16,20},
			{23,30,34,50}
		}, 3));
		
		System.out.println(obj.searchMatrix(new int[][] {
			{1,3,5,7},
			{10,11,16,20},
			{23,30,34,50}
		}, 13));
	}
}
