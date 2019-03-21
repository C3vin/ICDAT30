package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string of numbers and operators, return all possible results from computing all the 
different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:
Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 */
public class n241_Different_Ways_to_Add_Parentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if(c == '-' || c == '+' || c == '*') {
				String a = input.substring(0, i);
				String b = input.substring(i+1, input.length());
				List<Integer> a1 = diffWaysToCompute(a);
				List<Integer> b1 = diffWaysToCompute(b);

				for(int x : a1) {
					for(int y : b1) {
						if(c == '-') {
							res.add(x - y);
						} else if(c == '+') {
							res.add(x + y);
						} else if(c == '*') {
							res.add(x * y);
						}
					}
				}

			}
		}
		if(res.size() == 0) {
			//res.add(Integer.valueOf(input));
			res.add(Integer.parseInt(input));
		}
		return res;
	}
	public static void main(String[] args) {
		n241_Different_Ways_to_Add_Parentheses obj = new n241_Different_Ways_to_Add_Parentheses();
		System.out.println(obj.diffWaysToCompute("2-1-1"));
		System.out.println(obj.diffWaysToCompute("2*3-4*5"));
	}
}
