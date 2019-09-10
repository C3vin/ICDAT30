package LeetCode;

/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess 
what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess 
match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number 
but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive 
the secret number.
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to 
indicate the cows. 
Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

Example 2:
Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class n299_Bulls_and_Cows {
	//cs
	//time:O(n) space:O(1)
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] count = new int[10];
		for(int i=0; i<secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				if(count[secret.charAt(i) - '0']++ < 0) {
					cows++;
				}
				if(count[guess.charAt(i) - '0']-- > 0) {
					cows++;
				}
			}
		}
		return bulls + "A" + cows + "B";
	}
	
	public String getHint2(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] secret_count = new int[10];
		int[] guess_count = new int[10];
		
		for(int i=0; i<secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				secret_count[secret.charAt(i) - '0']++;
				guess_count[guess.charAt(i) - '0']++;
			}
		}
		for(int i=0; i<secret_count.length; i++) {
			cows = cows + Math.min(secret_count[i], guess_count[i]);	//just need once
		}
		
		return bulls + "A" + cows + "B";
	}
	public static void main(String[] args) {
		n299_Bulls_and_Cows obj = new n299_Bulls_and_Cows();
		System.out.println(obj.getHint("1807", "7810"));
		System.out.println(obj.getHint("1123", "0111"));
		System.out.println(obj.getHint2("1807", "7810"));
		System.out.println(obj.getHint2("1123", "0111"));
	}
}
