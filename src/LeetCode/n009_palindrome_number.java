package LeetCode;

//Determine whether an integer is a palindrome. Do this without extra space.
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
		while(x != 0) {				   //Reverse int 
			ret = ret * 10 + (x % 10); //F: Need * 10 !
			x = x / 10;
		}
		return ret;
	}
	
	//Revert half of the number
	public boolean isPailindrome3(int x) {
		if(x < 0 || (x != 0 && x % 10 == 0))		//handle special case '10', need x != 0. Because '0' is true
			return false;
		int ret = 0;
		while(x > ret) {
			ret = ret * 10 + (x % 10);
			x = x / 10;
		}
		
		return x == ret || x == (ret/10);
	}
	public static void main(String[] args) {
		n009_palindrome_number obj = new n009_palindrome_number();
		System.out.println(obj.isPailindrome2(10101));
		System.out.println(obj.isPailindrome2(1232));
		System.out.println(obj.isPailindrome3(10101));
		System.out.println(obj.isPailindrome3(0));
	}
}
