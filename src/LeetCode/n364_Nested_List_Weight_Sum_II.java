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
		int intSum = 0;
		return helper(nestedList, intSum);
	}

	private int helper(List<NestedInteger> nestedList, int intSum) {
		List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
		int listSum = 0;

		for(NestedInteger ni : nestedList) {
			if(ni.isInteger()) {
				intSum = intSum + ni.getInteger();
			} else {
				nextLevel.addAll(ni.getList());
			}
		}
		listSum = nextLevel.isEmpty() ? 0 : helper(nextLevel, intSum);
		return listSum + intSum;
	}
}
