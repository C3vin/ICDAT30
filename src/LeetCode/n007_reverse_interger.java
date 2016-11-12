package LeetCode;

@Alg(type="Math", com="A", level="easy", num=7)
public class n007_reverse_interger {
	public int reverseInterger(int x) {
		long result = 0;
		while (x!= 0) {
			result = result * 10 + (x%10);
			System.out.println(result);
/*			if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE; 
			if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;*/
			x = x/10;
		}
		return (int)result;
	}
	public static void main(String[] args) {
		n007_reverse_interger obj = new n007_reverse_interger();
		int x = 123;//Integer.MAX_VALUE;
		System.out.println(x + " : "+ obj.reverseInterger(x));
	}
}
