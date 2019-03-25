package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to 
add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []
 */
public class n282_Expression_Add_Operators {
	//sol
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<String>();
		dfs(num, target, 0, "", 0, 0, res);
		return res;
	}

	//https://github.com/awangdev/LintCode/blob/master/Java/Expression%20Add%20Operators.java
	private void dfs(String num, int target, int index, String tmp, long curRes, long preNum, List<String> res) {
		if(curRes == target && index == num.length()) {
			res.add(new String(tmp));
			return;
		}

		for(int i=index; i<num.length(); i++) {
			String sub = num.substring(index, i+1);
			if(sub.length() > 1 && sub.charAt(0) == '0') {
				return;
			}
			long curNum = Long.parseLong(sub);
			if(index == 0) {
				dfs(num, target, i+1, tmp+curNum, curNum, curNum, res);
			} else {
				dfs(num, target, i+1, tmp+"+"+curNum, curRes+curNum, curNum, res);
				dfs(num, target, i+1, tmp+"-"+curNum, curRes-curNum, -curNum, res);
				dfs(num, target, i+1, tmp+"*"+curNum, (curRes-preNum)+(preNum*curNum), (preNum*curNum), res);
			}
		}
	}

	//https://segmentfault.com/a/1190000003797204
	//https://blog.csdn.net/yy254117440/article/details/54581450
	//https://www.cnblogs.com/grandyang/p/4814506.html

	public static void main(String[] args) {
		n282_Expression_Add_Operators obj = new n282_Expression_Add_Operators();
		System.out.println(obj.addOperators("123", 6));
		System.out.println(obj.addOperators("232", 8));
		System.out.println(obj.addOperators("105", 5));
		System.out.println(obj.addOperators("00", 0));
		System.out.println(obj.addOperators("3456237490", 9191));

	}
}
