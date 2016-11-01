package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	public int depthSum(List<NestedInteger> nestedList) {
		int depth = 1;
		return helper(nestedList, depth);
	}

	private int helper(List<NestedInteger> nestedList, int depth) {
		if(nestedList.size() == 0 || nestedList == null)
			return 0;

		int sum=0;
		for(NestedInteger ni : nestedList) {
			if(ni.isInteger()) {	//int in
				sum = sum + ni.getInteger() * depth;		//depth
			} else {				//list depth+1
				sum = sum + helper(ni.getList(), depth+1);
			}
		}
		return sum;
	}
	
	//Iterative
	public int depthSum2(List<NestedInteger> nestedList) {
		//if(nestedList.size() == 0) return 0;
		int sum = 0;
		LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
		LinkedList<Integer> depth = new LinkedList<Integer>();
		
		for(NestedInteger ni: nestedList){
	        queue.offer(ni);
	        depth.offer(1);
	    }
		
		while(!queue.isEmpty()) {				//while!!!
			NestedInteger tmp = queue.poll();
	        int dep = depth.poll();
			if(tmp.isInteger()){
				sum = sum + (tmp.getInteger()*dep);
			} else {
				for(NestedInteger ni : tmp.getList()) {
					queue.offer(ni);
					depth.offer(dep+1);
				}
			}
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
