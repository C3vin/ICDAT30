package LeetCode;

public class n008_string_to_integer_atoi {
	  public int myAtoi(String str) {
		if(str == null)
			return 0;
		str = str.trim();
		if(str.length() == 0)
			return 0;
		
		boolean isNeg = false;
		int i = 0;
		if(str.charAt(0) == '+' || str.charAt(0) == '-') {
			i++;
			if(str.charAt(0) == '-')
				isNeg = true;
		}
		
		int res  = 0;
		while(i < str.length()) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9')
				break;
			int val = (int)(str.charAt(i) - '0');
			if(isNeg && res > -((Integer.MIN_VALUE + val)/10)) {		//-2147483648, /10 boundary
				System.out.print("@");
				return Integer.MIN_VALUE;
			}
			else if(!isNeg && res > (Integer.MAX_VALUE - val)/10)		//2147483647
				return Integer.MAX_VALUE;
			res = res * 10 + val;
			i++;
		}
		return isNeg? -res:res;
	  }
	  
	  public float myAtof(String str) {
		  float res = 0;
		  float decimalpoint = 0;
		  boolean flag = false;
		  int base = 1;
		  
		  for(char c : str.toCharArray()) {
			  if(c == '.') {
				  flag = true;
				  continue;
			  }
			  if(c < '0' || c > '9') {
				  return 0f;			//deal with 123.45w f: float
			  }
			  if(flag) {
				  decimalpoint = decimalpoint * 10 + (c - '0');		//F: need -'0'
				  base = base *10;
			  } else {
				  res = res * 10 + (c - '0');
			  }
		  }
		  if(decimalpoint > 0) {
			  decimalpoint = decimalpoint / base;
		  }
		  return res + decimalpoint;
	  }
	  public static void main(String[] args) {
		  n008_string_to_integer_atoi obj = new n008_string_to_integer_atoi();
		  System.out.println(obj.myAtoi(" -2147483648"));
		  System.out.println(obj.myAtof("123.45"));
	  }
}
