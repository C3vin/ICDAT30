package LeetCode;

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a##c", t = "#a#c"
Output: true
Explanation: Both s and t become "c".

Example 4:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 */
public class n844_Backspace_String_Compare {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length()-1;
		int j = T.length()-1;
		int count1 = 0;
		int count2 = 0;

		while(i >= 0 || j >= 0) {
			while(i >= 0) {
				if(S.charAt(i) == '#') {
					count1++;
					i--;
				} else if(count1 > 0) {
					count1--;
					i--;
				} else {
					break;						//this break !
				}
			}

			while(j >= 0) {
				if(T.charAt(j) == '#') {
					count2++;
					j--;
				} else if(count2 > 0) {
					count2--;
					j--;
				} else {
					break;						//this break !
				}
			}

			// If two actual characters are different
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
				return false;
			}
			
			if ((i >= 0) != (j >= 0)) {		//need to add this !!! 
				return false;				//e.g. S = "bxj##tw"; T = "bxj###tw";  i becomes 0 and j becomes -1
			}

			i--; 
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		n844_Backspace_String_Compare obj = new n844_Backspace_String_Compare();
		System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
		System.out.println(obj.backspaceCompare("ab##", "c#d#"));
		System.out.println(obj.backspaceCompare("a##c", "#a#c"));
		System.out.println(obj.backspaceCompare("a#c", "bc"));
		System.out.println(obj.backspaceCompare("bxj##tw", "bxj###tw"));
	}
}
