package LeetCode;

//Given a roman numeral, convert it to an integer.
//VI = 5+1, II = 1+1, VIII = 8, III = 3, but IV = 4 (5-1)
public class n013_roman_to_integer {
	public int romanToInt(String s) {
		int[] transfer = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case 'M':
				transfer[i] = 1000;
				break;
			case 'D':
				transfer[i] = 500;
				break;
			case 'C':
				transfer[i] = 100;
				break;
			case 'L':
				transfer[i] = 50;
				break;
			case 'X':
				transfer[i] = 10;
				break;
			case 'V':
				transfer[i] = 5;
				break;
			case 'I':
				transfer[i] = 1;
				break;
			}
		}
		int sum = 0;
		for(int i=0; i<transfer.length-1; i++) {
			if(transfer[i] < transfer[i+1])
				sum = sum - transfer[i];			//why? e.g. IV, sum = 0 - 1 = -1. when return will do (-1) + last (5) = 4
			else {
				sum = sum + transfer[i];
			}
		}
		return sum + transfer[transfer.length-1]; 		//F: need to add last value, because we use 0 ~ transfer.length-1
	}
	public static void main(String[] args) {
		n013_roman_to_integer obj = new n013_roman_to_integer();
		System.out.println(obj.romanToInt("VI"));
		System.out.println(obj.romanToInt("CV"));
		System.out.println(obj.romanToInt("IV"));
	}
}
