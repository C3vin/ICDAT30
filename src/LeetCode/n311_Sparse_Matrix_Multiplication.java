package LeetCode;

/*	 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |               */
public class n311_Sparse_Matrix_Multiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int[][] C = new int[A.length][B[0].length];

		for(int i=0; i<C.length; i++) {
			for(int k=0; k<A[0].length; k++) {
				if(A[i][k]!=0){
					for(int j=0; j<C[0].length; j++) {
						C[i][j] += A[i][k] * B[k][j]; 
					}
				}
			}
		}
		for(int r=0; r<C.length; r++) 
			for(int rr=0; rr<C[0].length; rr++)
				System.out.print(C[r][rr]);
		return C;
	}
	public static void main(String[] args) {
		n311_Sparse_Matrix_Multiplication obj = new n311_Sparse_Matrix_Multiplication();
		int[][] A = {{1,0,0},{-1,0,3}};
		int[][] B = {{7,0,0},{0,0,0}, {0,0,1}};
		System.out.println(obj.multiply(A, B));
	}
}
