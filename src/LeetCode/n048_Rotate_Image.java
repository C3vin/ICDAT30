package LeetCode;

public class n048_Rotate_Image {
	 public void rotate(int[][] matrix) {
		 int m = matrix.length;
		 int n = matrix[0].length;
		 
		 int[][] result = new int[m][n];
		 
		 for(int i=0; i<m; i++) {
			 for(int j=0; j<n; j++) {
				 result[j][n-1-i] = matrix[i][j];		//(0,0) -> (0,2)
			 }
		 }
		 for(int i=0; i<m; i++) {
			 for(int j=0; j<n; j++) {
				 matrix[i][j] = result[i][j];
			 }
		 }
		 
		 for(int i=0; i<m; i++) {
			 for(int j=0; j<n; j++) {
				 System.out.print(matrix[i][j]);
			 }System.out.print("\n");
		 }
	 }

	 //In place
	 public void rotateIP(int[][] matrix) {
		 int m = matrix.length;
		 int n = matrix[0].length;
		 
		 for(int i=0; i<m/2; i++) {
			 for(int j=0; j<(m+1)/2; j++) {
				 int tmp = matrix[i][j];
				 matrix[i][j] = matrix[m-1-j][i];
				 matrix[m-1-j][i] = matrix[m-1-i][m-1-j];
				 matrix[m-1-i][m-1-j] = matrix[j][m-1-i];
				 matrix[j][m-1-i] = tmp;
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
				{{1,2,0,4,5},
				 {1,2,3,0,6},
			     {1,0,0,4,6},
			     {1,2,0,4,5},
			     {1,2,3,4,6}};
		 
		 obj.rotate(matrix);
		 System.out.println("");
		 int[][] matrix1 = 
				{{1,2,0,4,5},
				 {1,2,3,0,6},
			     {1,0,0,4,6},
			     {1,2,0,4,5},
			     {1,2,3,4,6}};
		 
		 obj.rotateIP(matrix1);
	 }
}
