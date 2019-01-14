package LeetCode;

/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

Example 1:
Input: "ab-cd"
Output: "dc-ba"

Example 2:
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class n917_Reverse_Only_Letters {
	public String reverseOnlyLetters(String S) {
		char[] ch = S.toCharArray();
		int start = 0;
		int end = ch.length-1;
		
		while(start < end) {
			if(Character.isLetter(ch[start]) && Character.isLetter(ch[end])) {
				//swap
				char tmp = ch[start];
				ch[start] = ch[end];
				ch[end] = tmp;
				
				start++;
				end--;
			} else if(Character.isLetter(ch[start]) && !Character.isLetter(ch[end])) {				
				end--;
			} else if(!Character.isLetter(ch[start]) && Character.isLetter(ch[end])) {
				start++;
			} else {
				start++;				//F: need this to deal with non-letter e.g. 7_28]
				end--;
			}
		}
		return String.valueOf(ch);
		//return new String(ch);
	}
	public static void main(String[] args) {
		n917_Reverse_Only_Letters obj = new n917_Reverse_Only_Letters();
		System.out.println("ab-cd \n" + obj.reverseOnlyLetters("ab-cd"));
		System.out.println("a-bC-dEf-ghIj \n" + obj.reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println("Test1ng-Leet=code-Q! \n" + obj.reverseOnlyLetters("Test1ng-Leet=code-Q!"));

		//F: special case
		System.out.println("7_28] \n" + obj.reverseOnlyLetters("7_28]"));
	}
}
