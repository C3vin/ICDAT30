package LeetCode;

/*
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class n415_Add_Strings {
	public String addStrings(String num1, String num2) {
		String res = "";
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		
		while(i >= 0 || j >= 0) {
			if(i >= 0) {
				carry = carry + num1.charAt(i) - '0';
				i--;
			}
			if(j >= 0) {
				carry = carry + num2.charAt(j) - '0';
				j--;
			}
			
			res = Integer.toString(carry % 10) + res;
			carry = carry / 10;
		}
		
		if(carry != 0) {
			res = "1" + res;	//need string
		}

		return res;
	}
	public static void main(String[] args) {
		n415_Add_Strings obj = new n415_Add_Strings();
		//System.out.println(obj.addStrings("100", "23"));
		System.out.println(obj.addStrings("1", "9"));
	}
}
