package LeetCode;

/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Example:
Input: s = "++++"
Output: true 
Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */
public class n294_Flip_Game_II {
	public boolean canWin(String s) {
		char[] c = s.toCharArray();
		if(s.length() == 0 || s.length() <2) 
			return false;
		
		for(int i=0; i<c.length-1; i++) {
			if(c[i] == '+' && c[i+1] == '+') {
				c[i] = '-';
				c[i+1] = '-';
				boolean win = canWin(new String(c));	
				c[i] = '+';
				c[i+1] = '+';
				if(!win) {						// if the opposite cannot win, then you can gaurantee to win
					return true;
				}
			}
		}
		return false;
	}
	
	//12591 ms bad!
	public boolean canWin2(String s) {
		if(s.length() == 0 || s.length() <2) 
			return false;
		
		for(int i=0; i<s.length()-1; i++) {
			StringBuilder sb = new StringBuilder(s);
			if(sb.charAt(i) == '+' && sb.charAt(i+1) == '+') {
				sb.replace(i, i+1+1, "--");
				System.out.println(sb);
				if(!canWin(sb.toString())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n294_Flip_Game_II obj = new n294_Flip_Game_II();
		System.out.println(obj.canWin("++--"));
		System.out.println(obj.canWin("++++"));
		System.out.println(obj.canWin2("++++"));
	}
}
