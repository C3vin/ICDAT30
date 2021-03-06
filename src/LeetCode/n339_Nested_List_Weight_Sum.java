package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.

Example 2:
Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class n339_Nested_List_Weight_Sum {
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	class NI implements NestedInteger {
		private int val;
		private List<NestedInteger> vals = new ArrayList<NestedInteger>();
		private boolean isInt = false;

		public NI(){}

		public NI(int v) {
			this.val = v;
			isInt = true;
		}

		public void add(NI ni) {
			vals.add(ni);
		}

		public String toString() {
			StringBuffer sbf = new StringBuffer();
			if(this.isInt) sbf.append(this.val).append(", ");
			else
				for(NestedInteger ni: this.vals) {
					if(!ni.isInteger())
						sbf.append("[");
					sbf.append(ni.toString());
					if(!ni.isInteger()) sbf.append("]");
				}
			return sbf.toString();
		}

		public NI(String s) {
			LinkedList<NI> stack = new LinkedList<NI>();
			stack.add(this);

			NI cur = this;
			String[] strs = s.split(",");
			for(int i=0; i<strs.length;) {
				String ss = strs[i];

				ss = ss.trim();

				if(ss.startsWith("[")) {
					NI ni = new NI();
					stack.push(ni);

					cur.add(ni);
					cur = ni;
					ss = ss.substring(1);
					strs[i] = ss;

					continue;
				}

				int levels = 0;
				while(ss.endsWith("]")) {
					levels ++;

					ss = ss.substring(0, ss.length()-1);
					ss = ss.trim();
				}

				NI ni = new NI(Integer.parseInt(ss));
				cur.add(ni);

				while(levels > 0) {
					cur = stack.pop();
					levels--;
				}
				cur = stack.peek();
				i++;
			}
		}
		@Override
		public boolean isInteger() {
			return isInt;
		}

		@Override
		public Integer getInteger() {
			return this.val;
		}

		@Override
		public List<NestedInteger> getList() {
			return this.vals;
		}

	}
	
	//Recursive
	//DFS
	public int depthSum(List<NestedInteger> nestedList) {
		if(nestedList.size() == 0 || nestedList == null) {
			return 0;
		}
		
		return helper(nestedList, 1);
	}

	private int helper(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		
		for(NestedInteger nest : nestedList) {
			if(nest != null) {
				if(nest.isInteger()) {
					sum = sum + nest.getInteger() * depth;
				} else {
					sum = sum + helper(nest.getList(), depth+1);	//F: need sum
				}
			}
		}
		
		return sum;
	}
	
	//BFS
	public int depthSum2(List<NestedInteger> nestedList) {
		if(nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		
		int depth = 1;
		int sum = 0;
		
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);		//F: assigned when we created 
		//Queue<NestedInteger> queue = new LinkedList<NestedInteger>();		
		//queue.addAll(nestedList);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				NestedInteger nest = queue.poll();
				
				if(nest.isInteger()) {
					sum = sum + nest.getInteger() * depth;
				} else {
					queue.addAll(nest.getList());			//F: no need sum, not Recursive!	
				}
			}
			depth++;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		n339_Nested_List_Weight_Sum obj = new n339_Nested_List_Weight_Sum();
		NI ni = obj.new NI("[1,1],2,[1,1]");
		System.out.println(obj.depthSum(ni.getList()));
		System.out.println(obj.depthSum2(ni.getList()));
	}
}
