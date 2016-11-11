package LeetCode;

@Alg(type="Math", com="NA", level="easy", num=9)
public class n009_palindrome_number {
	public boolean isPailindrome(int x) {
		if(x<0)
			return false;
		int div = 1;
		while(div <= x/10) {	//Need <= x/10
			div = div * 10;
		}
		while(x > 0) {
			if(x/div != x%10) 	//compare front and end 
				return false;
			x = (x%div)/10;		//e.g. x=12121 -> x=212 (dele front and end) 
			div = div/100;		// why 100? cuz x dele f and e 
		}
		return true;
	}
	public static void main(String[] args) {
		n009_palindrome_number obj = new n009_palindrome_number();
		System.out.println(obj.isPailindrome(10101));
		System.out.println(obj.isPailindrome(1232));
	}
}
