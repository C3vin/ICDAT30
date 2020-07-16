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

	public int myAtoi2(String str) {
		str = str.trim();				//handle " " case, before if check
		
		if(str == null || str.length() == 0) {
			return 0;
		}
		

		long res = 0;				//long
		int sign = 1;
		int start = 0;

		char firstChar = str.charAt(0);	//need to avoid '+' or '-' cases
		
		if(firstChar == '+') {			//need before '-'
			sign = 1;
			start++;
		}
		if(firstChar == '-') {
			sign = -1;
			start++;
		}

		for(int i=start; i<str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return (int)res * sign;
			}
			
			res = res * 10 + str.charAt(i) - '0';
			
			if(sign == 1 && res > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(sign == -1 && res > Integer.MAX_VALUE) {				//Integer.MAX_VALUE !!!!!!!!
				return Integer.MIN_VALUE;                           //but here use MIN_VALUE
			}
		}

		return (int)res * sign;							//convert
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
		System.out.println(obj.myAtoi("-"));
		System.out.println(obj.myAtof("123.45"));

		System.out.println(obj.myAtoi2(" "));
		System.out.println(obj.myAtoi2("-"));
		System.out.println(obj.myAtoi2("123.45"));
	}
}
