package LeetCode;

public class n070_Climbing_Stairs {
	public int climbStairs(int n) {
		int f1 = 1;
		int f2 = 2;
		
		if(n == 1) return f1;
		if(n == 2) return f2;
		
		for(int i=3; i<=n; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f2;
	}
	
	public static void main(String[] args) {
		n070_Climbing_Stairs obj = new n070_Climbing_Stairs();
		System.out.println(obj.climbStairs(3));
	}
}
