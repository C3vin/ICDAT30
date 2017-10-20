package LeetCode;

//Given an integer, convert it to a roman numeral.
public class n012_integer_to_roman {
	 public String intToRoman(int num) {
		 int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		 String[] rval = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		 //String res = "";
		 StringBuilder sb = new StringBuilder();
		 
		 for(int i=0; i<val.length; i++) {
			 while(num >= val[i]) {				//F: need this to locate the i 
				 //res = res + rval[i];
				 sb.append(rval[i]);
				 num = num - val[i];
			 }
		 }
		 return sb.toString();
	 }
	 
	 public static void main(String[] args) {
		 n012_integer_to_roman obj = new n012_integer_to_roman();
		 System.out.println(obj.intToRoman(3978));
		 System.out.println(obj.intToRoman(11));

	 }

}
