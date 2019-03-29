package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
F.length >= 3;
and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

Example 1:
Input: "123456579"
Output: [123,456,579]

Example 2:
Input: "11235813"
Output: [1,1,2,3,5,8,13]

Example 3:
Input: "112358130"
Output: []
Explanation: The task is impossible.

Example 4:
Input: "0123"
Output: []
Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.

Example 5:
Input: "1101111"
Output: [110, 1, 111]
Explanation: The output [11, 0, 11, 11] would also be accepted.
Note:

1 <= S.length <= 200
S contains only digits.
 */
public class n842_Split_Array_into_Fibonacci_Sequence {
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(S, 0, tmp, res);
		return res;
	}
	private void dfs(String S, int index, List<Integer> tmp, List<Integer> res) {
		if(!res.isEmpty()) {
			return;
		}
		if(index == S.length() && tmp.size() >= 3) {
			res.addAll(tmp);			
			return;
		}
		for(int i=index; i<S.length(); i++) {
			String sub = S.substring(index, i+1);
			long num = Long.parseLong(sub);

			if((sub.charAt(0) == '0' && sub.length() > 1) || sub.length() > 10) {	//wny 10, cuz max int is 2147483647
				break;
			}

			if(num > Integer.MAX_VALUE) {
				break;
			}
			int size = tmp.size();
			
			if(tmp.size() >= 2 && num != tmp.get(size-2) + tmp.get(size-1)) {
				continue;
			}
			tmp.add(Long.valueOf(num).intValue());
			dfs(S, i+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}
	}

	public List<Integer> splitIntoFibonacci2(String S) {
		List<Integer> res = new ArrayList<Integer>();
		dfs2(S, 0, res);
		return res;
	}

	private boolean dfs2(String S, int index, List<Integer> res) {
		if(index == S.length() && res.size() > 2) {
			return true;
		}
		for(int i=index; i<S.length(); i++) {
			if(S.charAt(0) == '0' && i != index) {
				break;
			}
			long curNum = Long.parseLong(S.substring(index, i+1));
			if(curNum > Integer.MAX_VALUE) {
				return false;
			}

			int size = res.size();
			if(size >= 2 && curNum > res.get(size-2) + res.get(size-1)) {
				break;
			}
			if(size <= 1 || curNum == res.get(size-2) + res.get(size-1)) {
				res.add(Long.valueOf(curNum).intValue());			
				if(dfs2(S, i+1, res)) {
					return true;
				}
				res.remove(res.size()-1);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		n842_Split_Array_into_Fibonacci_Sequence obj = new n842_Split_Array_into_Fibonacci_Sequence();
		System.out.println(obj.splitIntoFibonacci("1101111"));
		System.out.println(obj.splitIntoFibonacci("123456579"));
		System.out.println(obj.splitIntoFibonacci2("123456579"));
	}
}

