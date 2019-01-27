package LeetCode;

//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
/*
Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
 */
public class n043_Multiply_Strings {
	public String multiply(String num1, String num2) {
		if(num1.length() == 0 || num2.length() == 0 || num1 == null || num2 == null) return null;
		if(num1.equals("0") || num2.equals("0")) return "0";	//F: string use equals()

		//num1 = new StringBuilder(num1).reverse().toString();
		//num2 = new StringBuilder(num2).reverse().toString();	//test if no reverse

		int[] d = new int[num1.length() + num2.length()];	//enough

		for(int i=0; i<num1.length(); i++) {
			int a = num1.charAt(num1.length()-1-i)-'0';		//F:-'0' & why need last-1-i, when -i will let element move <---
			for(int j=0; j<num2.length(); j++) {
				int b = num2.charAt(num2.length()-1-j)-'0';
				d[i+j] = d[i+j] + a * b; 
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<d.length; i++) {
			int digit = d[i]%10;
			int carry = d[i]/10;
			sb.insert(0, digit);
			if(carry >0) {	//update
				d[i+1] = d[i+1] + carry;
			}
		}
		if(sb.charAt(0) == '0' && sb.length() > 0) {
			//sb = sb.deleteCharAt(0);	//remove the first '0'
			return sb.substring(1);
		}
		return sb.toString();
	}

	//sol2: better
	public String multiply2(String num1, String num2) {
		//reverse first
		String s1 = new StringBuilder(num1).reverse().toString();
		String s2 = new StringBuilder(num2).reverse().toString();
		int[] d = new int[s1.length() + s2.length()];

		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				d[i+j] = d[i+j] + (s1.charAt(i) - '0')*(s2.charAt(j) - '0');
			}
		}
		String res = new String();
		for(int i=0; i<d.length; i++) {
			int digit = d[i]%10;
			int carry = d[i]/10;
			if(i+1 < d.length) {
				d[i+1] = d[i+1] + carry;
			}
			res = digit + res;			//String concatenated! can't do res + digit
		}
		while(res.length() > 1 && res.charAt(0) == '0') {
			res = res.substring(1);
		}
		return res;
	}

	//sol3
	public String multiply3(String num1, String num2) {
		if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
			return "";
		}
		
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        int mult;
		
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				mult = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
				int p1 = i+j;
				int p2 = i+j+1;
				int sum = mult + res[p2];
				
				res[p1] = res[p1] + sum/10;					//???
				res[p2] = sum%10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<res.length; i++) {
			if(!(sb.length() == 0 && res[i] == 0)) {		//need check sb.length() == 0, cuz some '0' is in the middle
				sb.append(res[i]);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
	public static void main(String[] args) {
		n043_Multiply_Strings obj = new n043_Multiply_Strings();
		System.out.println(obj.multiply("321", "43"));    //13803
		System.out.println(obj.multiply("9133", "0"));    //0
		System.out.println(obj.multiply("98", "9"));     //882
		System.out.println(obj.multiply2("98", "9"));     //882
		System.out.println(obj.multiply2("2", "3"));     //6
		System.out.println(obj.multiply2("123", "456"));     //56088
		System.out.println(obj.multiply3("123", "456"));     //56088
	}
}
