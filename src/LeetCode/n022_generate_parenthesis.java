package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n022_generate_parenthesis {
	public List<String> generateParenthesis(int n) {
		
	    ArrayList<String> result = new ArrayList<String>();
	    dfs(result, "", n, n);
	    return result;
	}

	public void dfs(ArrayList<String> result, String s, int left, int right) {
		if(left > right) {
			return;
		}
		if(left == 0 && right == 0) {
			result.add(s);
			System.out.println(result);
			return; 	
		}
		
		if(left > 0) {
			dfs(result, s+"(", left-1, right);
		}
		
		if(right > 0) {
			dfs(result, s+")", left, right-1);
		}
	}
	
	public static void main(String[] args) {
		n022_generate_parenthesis obj = new n022_generate_parenthesis();
		obj.generateParenthesis(3);
	}
}
