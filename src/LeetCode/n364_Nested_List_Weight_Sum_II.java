package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import LeetCode.n339_Nested_List_Weight_Sum.NI;

/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. 
i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.

Example 2:
Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */
public class n364_Nested_List_Weight_Sum_II {
	public interface NestedInteger {
		/*		// Constructor initializes an empty nested list.
		public NestedInteger();

		// Constructor initializes a single integer.
		public NestedInteger(int value);*/

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni);

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

		@Override
		public void setInteger(int value) {
			// TODO Auto-generated method stub

		}

		@Override
		public void add(NestedInteger ni) {
			// TODO Auto-generated method stub

		}
	}

//	public int depthSumInverse(List<NestedInteger> nestedList) {
//		if(nestedList.size() == 0 || nestedList == null) return 0;
//
//		int depth = 1;
//		int maxDepth = helperMax(nestedList, depth);
//
//		return helper(nestedList, maxDepth);
//	}
//	public int helperMax(List<NestedInteger> nestedList, int depth) {    //Max depth
//		int max = depth;        //F: max <- depth
//		for(NestedInteger ni : nestedList) {
//			if(!ni.isInteger())
//				max = Math.max(max, helperMax(ni.getList(), depth+1));                  //F: need to maintain Max, cuz will overwrite
//		}
//		return max;
//	}
//	public int helper(List<NestedInteger> nestedList, int maxDepth) {
//		int sum = 0;
//		for(NestedInteger ni : nestedList) {
//			if(ni.isInteger()) {
//				sum = sum + ni.getInteger() * maxDepth;
//			} else {
//				sum = sum + helper(ni.getList(), maxDepth-1);
//			}
//		}
//		return sum;
//	}
//	
	//Recursive
	//DFS 
	public int depthSumInverse2(List<NestedInteger> nestedList) {
		if(nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		int depth = helperDepth(nestedList);
		return helper(nestedList, depth);		
	}
	private int helperDepth(List<NestedInteger> nestedList) {
		if(nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		
		int maxDepth = 0;
		for(NestedInteger nest : nestedList) {
			if(nest.isInteger()) {
				maxDepth = Math.max(maxDepth, 1);
			} else {
				maxDepth = Math.max(maxDepth, helperDepth(nest.getList())+1);
			}
		}
		
		return maxDepth;
	}
	private int helper(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		
		for(NestedInteger nest : nestedList) {
			if(nest.isInteger()) {
				sum = sum + nest.getInteger() * depth;
			} else {
				sum = sum + helper(nest.getList(), depth-1);
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		n364_Nested_List_Weight_Sum_II obj = new n364_Nested_List_Weight_Sum_II();
		NI ni = obj.new NI("[1,1],2,[1,1]");
		System.out.println(obj.depthSumInverse2(ni.getList()));
	}
}
