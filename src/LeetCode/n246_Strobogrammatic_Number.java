package LeetCode;

import java.util.HashMap;

//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//For example, the numbers "69", "88", and "818" are all strobogrammatic.
public class n246_Strobogrammatic_Number {
	//hashmap
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		map.put('1', '1');
		map.put('0', '0');

		int l = 0;
		int r = num.length()-1;
		while(l <= r) {
			if(!map.containsKey(num.charAt(l)))
				return false;
			if(map.get(num.charAt(l)) != num.charAt(r))		//compare value and right num char
				return false;
			l++;
			r--;
		}
		return true;
	}
	public static void main(String[] args) {
		n246_Strobogrammatic_Number obj = new n246_Strobogrammatic_Number();
		String num = "81818";
		System.out.println(obj.isStrobogrammatic(num));
	}
}
