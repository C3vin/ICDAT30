package LeetCode;

/*
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
public class n344_Reverse_String {
	//We can just change half of the string, O(n/2) 3m
	public String reverseString(String s) { 
		char[] ch = s.toCharArray();
		int half = s.length()/2;
		char tmp;
		//swap
		for(int i=0; i<half; i++) {			
			tmp = ch[i];
			ch[i] = ch[ch.length-i-1];		//F: need '-i'  
			ch[ch.length-i-1] = tmp;
		}
		return new String(ch);
	}

	//sol2
	public String reverseString2(String s) {
		int head = 0;
		int tail = s.length()-1;
		char[] c = new char[s.length()];
		
		while(head <= tail) {
			c[head] = s.charAt(tail);
			c[tail] = s.charAt(head);
			head++;
			tail--;
		}
		return new String(c);
	}

	//sol3 StringBuilder
	public String reverseString3(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static void main(String[] args) {
		n344_Reverse_String obj = new n344_Reverse_String();
		System.out.println(obj.reverseString("hello world"));
		System.out.println(obj.reverseString2("hello world"));
		System.out.println(obj.reverseString3("hello world"));
	}
}
