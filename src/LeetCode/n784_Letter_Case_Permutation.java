package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:
S will be a string with length between 1 and 12.
S will consist only of letters or digits.
 */
public class n784_Letter_Case_Permutation {
	public List<String> letterCasePermutation(String S) {
		List<String> res = new ArrayList<String>();
		char[] c = new char[S.length()];
		dfs(S, c, 0, res);
		return res;
	}
	//dfs
	private void dfs(String S, char[] c, int i, List<String> res) {
		if(i == S.length()) {
			res.add(new String(c));
			return;
		}
		if(!Character.isLetter(S.charAt(i))) {
			c[i] = S.charAt(i);
			dfs(S, c, i+1, res);
		} else {
			c[i] = Character.toLowerCase(S.charAt(i));
			dfs(S, c, i+1, res);
			c[i] = Character.toUpperCase(S.charAt(i));
			dfs(S, c, i+1, res);
		}
	}
	public static void main(String[] args) {
		n784_Letter_Case_Permutation obj = new n784_Letter_Case_Permutation();
		System.out.println(obj.letterCasePermutation("a1b2"));
	}
}
