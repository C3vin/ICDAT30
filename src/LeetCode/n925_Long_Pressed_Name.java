package LeetCode;

/*
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

Example 3:
Input: name = "leelee", typed = "lleeelee"
Output: true

Example 4:
Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
*
*/
public class n925_Long_Pressed_Name {
	public boolean isLongPressedName(String name, String typed) {
		int index = 0;
		for(int i=0; i<name.length(); i++) {
			while(index < typed.length() && name.charAt(i) != typed.charAt(index)) {
				index++;
			}
			if(index >= typed.length()) {
				return false;
			}
			index++;
		}
		return true;
	}
	public static void main(String[] args) {
		n925_Long_Pressed_Name obj = new n925_Long_Pressed_Name();
		System.out.println(obj.isLongPressedName("alex", "aaleex"));
		System.out.println(obj.isLongPressedName("saeed", "ssaaedd"));
		System.out.println(obj.isLongPressedName("leelee", "lleeelee"));
		System.out.println(obj.isLongPressedName("laiden", "laiden"));
		System.out.println(obj.isLongPressedName("pyplrz", "ppyypllr"));
	}
}
