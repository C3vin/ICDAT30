package LeetCode;

/*
 * Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class n067_Add_Binary {
	public String addBinary(String a, String b) {
		//check a and b first
		if(a == null || a.length() == 0) 
			return b;
		if(b == null || b.length() == 0) 
			return a;
		
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		
		int i = a.length()-1;
		int j = b.length()-1;
		
		while(i >=0 || j >=0) {				// || not &&
			if(i>=0) {
				carry = carry + a.charAt(i)-'0';
				i--;
			}
			if(j>=0) {
				carry = carry + b.charAt(j)-'0';
				j--;
			}
			
			sb.insert(0, carry%2);			//MUSE use insert(), tip: from head to tail ->
			carry = carry/2;
		}
		if(carry == 1) {
			sb.insert(0, 1);				//insert()
		}
		
		return sb.toString();
	}
	
	//if don't want to use sb.insert, just reverse in the end!
	public String addBinary2(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		
		while(i >= 0 || j >= 0) {				// || not &&
			int sum = carry;
			if(i >= 0) {
				sum = sum + a.charAt(i)-'0';
				i--;
			}
			if(j >= 0) {
				sum = sum + b.charAt(j)-'0';
				j--;
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if(carry != 0)
			sb.append(carry);
			
		return sb.reverse().toString();			//still need to use reverse() !!!
	}
	public static void main(String[] args) {
		n067_Add_Binary obj = new n067_Add_Binary();
		System.out.println(obj.addBinary("11", "1"));
		System.out.println(obj.addBinary("1010", "1011"));
		System.out.println(obj.addBinary2("11", "1"));
		System.out.println(obj.addBinary2("1010", "1011"));
	}
}
