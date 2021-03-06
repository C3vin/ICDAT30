package LeetCode;

import java.util.ArrayList;
import java.util.List;
public class n118_Pascal_Triangle {
	/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();	
		if(numRows <0) return res;

		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		res.add(pre);

		for(int i =2; i<numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j=0; j<pre.size()-1; j++) {
				cur.add(pre.get(j)+pre.get(j+1));
			}
			cur.add(1);
			res.add(cur);
			pre=cur;		//reset
		}
		return res;
	}

	//cs
	//time:O(n^2) space:O(n)
	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0; i<numRows; i++) {
			list.add(0, 1);
			for(int j=1; j<list.size()-1; j++) {
				list.set(j, list.get(j)+list.get(j+1));
			}
			res.add(new ArrayList<Integer>(list));
		}
		return res;
	}

	public static void main(String[] args) {
		n118_Pascal_Triangle obj = new n118_Pascal_Triangle();
		System.out.println(obj.generate(6));
		System.out.println(obj.generate2(6));
	}
}

