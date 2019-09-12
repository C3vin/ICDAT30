package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative index k where k <= 33, return the kth index row of the Pascal's triangle. 
Note that the row index starts from 0.

Example:
Input: 3
Output: [1,3,3,1]
Follow up:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class n119_Pascal_Triangle_II {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<rowIndex+1; i++) {
			res.add(0, 1);
			for(int j=1; j<res.size()-1; j++) {
				res.set(j, res.get(j)+res.get(j+1));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n119_Pascal_Triangle_II obj = new n119_Pascal_Triangle_II();
		System.out.println(obj.getRow(3));
	}
}
