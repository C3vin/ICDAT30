package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.
Write a function to compute all possible states of the string after one valid move.

Example:
Input: s = "++++"
Output: 
[
  "--++",
  "+--+",
  "++--"
]
Note: If there is no valid move, return an empty list [].
*/
public class n293_Flip_Game {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() < 2) {
			return res;
		}
		StringBuilder sb = new StringBuilder(s);
		for(int i=0; i<s.length()-1; i++) {
			String str = s.substring(i, i+2);
			if(str.equals("++")) {
				sb.replace(i, i+2, "--");
				res.add(sb.toString());
				sb.replace(i, i+2, "++");
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n293_Flip_Game obj = new n293_Flip_Game();
		System.out.println(obj.generatePossibleNextMoves("++++"));
	}
}
