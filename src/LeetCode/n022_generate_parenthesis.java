package LeetCode;

import java.util.ArrayList;
import java.util.List;

@Alg(type="NP", com="G", level="med", num=22)
public class n022_generate_parenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		String tmp = new String();
		//if(n <= 0) return res;
		helper(n, n, res, tmp);
		return res;
	}
	private void helper(int left, int right, List<String> res, String tmp) {
		if(left>right) //deal with ")("
			return;
		if(left == 0 && right == 0) {
			String s = new String(tmp);
			res.add(s);
			return;
		}
		if(left > 0) {
			helper(left-1, right, res, tmp+"(");
		}
		if(right > 0) {
			helper(left, right-1, res, tmp+")");
		}
	}
	public static void main(String[] args) {
		n022_generate_parenthesis obj = new n022_generate_parenthesis();
		System.out.println(obj.generateParenthesis(3));
	}
}
