package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * L
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
	public int depthSumInverse(List<NestedInteger> nestedList) {
		   if(nestedList.size() == 0 || nestedList == null) return 0;
	        
	        int depth = 1;
	        int maxDepth = helperMax(nestedList, depth);
	        
	        return helper(nestedList, maxDepth);
	}
	 public int helperMax(List<NestedInteger> nestedList, int depth) {    //Max depth
	        int max = depth;        //F: max <- depth
	        for(NestedInteger ni : nestedList) {
	            if(!ni.isInteger())
	                max = Math.max(max, helperMax(ni.getList(), depth+1));                  //F: need to maintain Max, cuz will overwrite
	        }
	        return max;
	    }
	    public int helper(List<NestedInteger> nestedList, int maxDepth) {
	        int sum = 0;
	        for(NestedInteger ni : nestedList) {
	            if(ni.isInteger()) {
	                sum = sum + ni.getInteger() * maxDepth;
	            } else {
	                sum = sum + helper(ni.getList(), maxDepth-1);
	            }
	        }
	        return sum;
	    }
}
