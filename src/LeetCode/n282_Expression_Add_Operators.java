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
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<String>();
		if(num == null || num.length() == 0) {
			return res;
		}
		dfs(num, target, 0, "", 0, 0, res);
		return res;
	}
	
	private void dfs(String num, int target, int start, String path, long val, long pre, List<String> res) {
		if(start == num.length()) {
			if(val == target) {
				res.add(path);
				return;
			}
		}
		for(int i=start; i<num.length(); i++) {
			if(i != start && num.charAt(start) == '0') {
				break; 			//?
			}
			long cur = Long.parseLong(num.substring(start, i+1));
			if(start == 0) {
				dfs(num, target, i+1, path+cur, cur, cur, res);
			} else {
				dfs(num, target, i+1, path+"+"+cur, val+cur, cur, res);
				dfs(num, target, i+1, path+"-"+cur, val-cur, -cur, res);				//-cur
				dfs(num, target, i+1, path+"*"+cur, val-pre+pre*cur, pre*cur, res);		//?
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
