package LeetCode;

// AA
/*A = [4, 3, 2, 6]
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

F(0) = 0A + 1B + 2C +3D
F(1) = 0D + 1A + 2B +3C
F(2) = 0C + 1D + 2A +3B
F(3) = 0B + 1C + 2D +3A
=>
F(1) = F(0) + sum - 4D
F(2) = F(1) + sum - 4C
F(3) = F(2) + sum - 4B

==> F(i) = F(i-1) + sum - n*A[n-i]
 */

public class n396_Rotate_Function {
	public int maxRotateFunction(int[] A) {
		if(A == null || A.length == 0) return 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		int tmp = 0;

		for(int i=0; i<A.length; i++) {
			sum = sum + A[i];
			tmp = tmp + i*A[i];		//just like t0
		}

		res = tmp;
		int n = A.length;
		for(int i=1; i<A.length; i++) {		//i=1 start at 1
			tmp = tmp + (sum - n*A[n-i]);
			res = Math.max(res, tmp);
		}

		return res;
	}

	public static void main(String[] args) {
		n396_Rotate_Function obj = new n396_Rotate_Function();
		int[] A = {4,3,2,6};
		System.out.println(obj.maxRotateFunction(A));
	}
}
