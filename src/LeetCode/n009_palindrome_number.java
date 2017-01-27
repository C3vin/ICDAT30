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

	public boolean isPailindrome2(int x) {
		if(x<0)
			return false;
		return x == reverseInt(x);
	}
	public int reverseInt(int x) {
		int ret = 0;
		while(x != 0) {
			ret = ret * 10 + x % 10; //F: Need * 10 !
			x = x / 10;
		}
		return ret;
	}
	public static void main(String[] args) {
		n009_palindrome_number obj = new n009_palindrome_number();
		System.out.println(obj.isPailindrome2(10101));
		System.out.println(obj.isPailindrome2(1232));
	}
}
