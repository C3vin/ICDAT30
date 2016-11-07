package LeetCode;

/**
'A' -> 1
'B' -> 2
...
'Z' -> 26 
 */
@Alg(type="DP,String", com="FB,M$", level="med", num=91)
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
	public static void main(String[] args) {
		n091_Decode_Ways obj = new n091_Decode_Ways();
		System.out.println("12: "+obj.numDecodings("12"));
		System.out.println("01: "+obj.numDecodings("01"));
		System.out.println("36: "+obj.numDecodings("36"));
	}
}
