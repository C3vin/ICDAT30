package LeetCode;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class n091_Decode_Ways {
	public int numDecodings(String s) {
		if (s.length()==0||s==null||s=="0") 			//F: "0", 
			return 0; 
		int[] dp = new int[s.length()+1];  
		dp[0] = 1;  									//dp[0], cuz we check the s=='0' first
		if (isValid(s.substring(0,1))) 					//1, s(0,1)
			dp[1] = 1;  
		else 
			dp[1] = 0; 									//need to handle first element, "01" can't decode!

		for(int i=2; i<s.length()+1; i++) {  			//F: only need one for loop
			if(isValid(s.substring(i-1,i))) {			//2, s(1,2)
				dp[i] = dp[i] + dp[i-1];  
			}
			if(isValid(s.substring(i-2,i))) { 			//12, s(0,2)
				dp[i] = dp[i] + dp[i-2];  
			}
		}  
		/*		for(int i=0; i<dp.length; i++)
		System.out.println(dp[i]);*/
		return dp[s.length()];  
	}  
	public boolean isValid(String s){  
		if (s.charAt(0)=='0') 						//!!! need to check first element
			return false;  
		int code = Integer.parseInt(s);  
		return code>=1 && code<=26;  
	}

	//better, but need to understand
	public int numDecodings2(String s) {
		/*
		空间复杂度为 O(1) 的解法，用两个变量 a, b 来分别表示 s[i-1] 和 s[i-2] 的解码方法，然后从 i=1 开始遍历，也就是字符串的第二个字符，
		判断如果当前字符为 '0'，说明当前字符不能单独拆分出来，只能和前一个字符一起，先将 a 赋为0，然后看前面的字符，
		如果前面的字符是1或者2时，就可以更新 a = a + b，然后 b = a - b，其实 b 赋值为之前的 a，如果不满足这些条件的话，那么 b = a
		 */
		if(s.length() == 0 || s == null || s.charAt(0) == '0') {
			return 0;
		}

		int c1 = 1;				//cur
		int c2 = 1; 			//pre

		for(int i=1; i<s.length(); i++) {		//why start at 1, cuz index 0 already check and also need to check i-1 later
			if(s.charAt(i) == '0') {
				c1 = 0;
			}

			//1.handle 1x e.g.12 or 13 2.handle double digit mapping only 11-26
			if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') {	
				c1 = c1 + c2;
				c2 = c1 - c2;
			} else {
				c2 = c1;
			}
		}

		return c1;
	}

	public static void main(String[] args) {
		n091_Decode_Ways obj = new n091_Decode_Ways();
//		System.out.println("12: "+obj.numDecodings("12"));
//		System.out.println("01: "+obj.numDecodings("01"));
//		System.out.println("226: "+obj.numDecodings("226"));

		System.out.println("123: "+obj.numDecodings2("123"));	//(1,2,3)(12,3)(1,23)
		System.out.println("212: "+obj.numDecodings2("212"));	//(2,1,2)(21,2)(2,12)
		System.out.println("211: "+obj.numDecodings2("211"));
		System.out.println("12: "+obj.numDecodings2("12"));
		System.out.println("01: "+obj.numDecodings2("01"));
		System.out.println("226: "+obj.numDecodings2("226"));
		System.out.println("1222: "+obj.numDecodings2("1222"));
	}
}
