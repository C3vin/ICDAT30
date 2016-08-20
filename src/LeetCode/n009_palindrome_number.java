package LeetCode;

public class n009_palindrome_number {
	public boolean isPailindrome(int x) {
		if(x<0)
			return false;
		
		int div = 1;
		while(div <= x/10) {
			div = div * 10;
		}
		while(x > 0) {
			if(x/div != x%10) 
				return false;
			x = (x%div)/10;		//?
			div = div/10;
		}
		return true;
	}
	
	public static void main(String[] args) {
		n009_palindrome_number obj = new n009_palindrome_number();
		System.out.println(obj.isPailindrome(101011));
	}
}
