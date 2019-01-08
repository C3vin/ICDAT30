package ctci;

/*
String Rotation: Assume you have a method i 5Su b 5 tr ing which checks if one word is a substring
of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
call to i5Sub5tring (e.g., "waterbottle" is a rotation of" erbottlewat").
 */
public class ctci_1_9_String_Rotation {
	private boolean isRotation(String s1, String s2) {
		if(s1.length() == s2.length() && s1.length() > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}

		return false;
	}
	private boolean isSubstring(String s1s1, String s2) {
		if(s1s1.indexOf(s2) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main (String args[]) {
		ctci_1_9_String_Rotation obj = new ctci_1_9_String_Rotation();
		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		System.out.println(obj.isRotation(s1, s2));
	}
}
