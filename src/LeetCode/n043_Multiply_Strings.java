package LeetCode;

//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
public class n043_Multiply_Strings {
	public String multiply(String num1, String num2) {
		if(num1.length() == 0 || num2.length() == 0 || num1 == null || num2 == null) return null;
		if(num1.equals("0") || num2.equals("0")) return "0";	//F: string use equals()
		
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();	//test if no reverse
		
		int[] d = new int[num1.length() + num2.length()];
		
		for(int i=0; i<num1.length(); i++) {
			int a = num1.charAt(i)-'0';		//F:-'0'
			for(int j=0; j<num2.length(); j++) {
				int b = num2.charAt(j)-'0';
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
		if(sb.charAt(0) == '0' && sb.length() > 0)
			sb = sb.deleteCharAt(0);	//remove the first '0'
		return sb.toString();
	}
	public static void main(String[] args) {
		n043_Multiply_Strings obj = new n043_Multiply_Strings();
		System.out.println(obj.multiply("9133", "0"));
	}
}
