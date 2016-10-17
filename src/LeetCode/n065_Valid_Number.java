package LeetCode;

public class n65_Valid_Number {
	/**
	 * "0" => true
	   " 0.1 " => true
	   "abc" => false
	   "1 a" => false
	   "2e10" => true
	 */
	public boolean isNumber(String s) {
		if(s.trim().isEmpty())
			return false;
		//[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?
		//String regex = "[+-]?(\\d+(\\.\\d+)?)(e?\\d+)?"; 
		String regex = "[+-]?(\\d+\\.?|\\.\\d+)\\d*(e?\\d+)?"; 
		//[0-9]+\.[0-9]+
		if(s.trim().matches(regex))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		n65_Valid_Number obj = new n65_Valid_Number();
		String s1 = "0";
		String s2 = "01.12";
		String s3 = "abc";
		String s4 = ".1";
		String s5 = "2e10";
		String s6 = "1.234e56";
		System.out.println(obj.isNumber(s1));
		System.out.println(obj.isNumber(s2));
		System.out.println(obj.isNumber(s3));
		System.out.println(obj.isNumber(s4));
		System.out.println(obj.isNumber(s5));
		System.out.println(obj.isNumber(s6));
	}
}
