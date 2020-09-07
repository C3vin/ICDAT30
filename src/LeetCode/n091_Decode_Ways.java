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
		if(s.length() == 0 || s == null || s.charAt(0) == '0') {
			return 0;
		}

		int c1 = 1;				//cur
		int c2 = 1; 			//pre

		for(int i=1; i<s.length(); i++) {		//why start at 1, cuz index 0 already check and also need to check i-1 later
			if(s.charAt(i) == '0') {
				c1 = 0;
			}

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
		System.out.println("12: "+obj.numDecodings("12"));
		System.out.println("01: "+obj.numDecodings("01"));
		System.out.println("226: "+obj.numDecodings("226"));

		System.out.println("12: "+obj.numDecodings2("12"));
		System.out.println("01: "+obj.numDecodings2("01"));
		System.out.println("226: "+obj.numDecodings2("226"));
		System.out.println("1222: "+obj.numDecodings2("1222"));
	}
}
