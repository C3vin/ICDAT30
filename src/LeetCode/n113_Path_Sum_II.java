package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class n113_Path_Sum_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	//Recursion
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
/*		if(root == null)
			return res;*/
		List<Integer> curList = new LinkedList<Integer>();
		helper(root, sum, 0, curList, res);
		
		return res;
	}
	private void helper(TreeNode root, int sum, int curSum, List<Integer> curList, List<List<Integer>> res) {
		if(root == null)
			return;
		curSum = curSum + root.val;
		curList.add(root.val);
		
		if(root.left == null && root.right == null && curSum == sum)
			res.add(new LinkedList<Integer>(curList));
		if(root.left != null) {
			helper(root.left, sum, curSum, curList, res);
			//curList.remove(curList.size()-1);			//because if it match, it will add to the res
		}
		if(root.right != null) {
			helper(root.right, sum, curSum, curList, res);
			//curList.remove(curList.size()-1);
		}
		curList.remove(curList.size()-1);			//just need once!
	}
	
	//Recursion
	public List<List<Integer>> pathSum3(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> curList = new LinkedList<Integer>();
		
		helper3(root, sum, curList, res);
		
		return res;
	}
	private void helper3(TreeNode root, int sum, List<Integer> curList, List<List<Integer>> res) {
		if(root == null)
			return;
		
		sum = sum - root.val;		//no need curSum
		curList.add(root.val);
		
		if(root.left == null && root.right == null && sum == 0)
			res.add(new LinkedList<Integer>(curList));
		
		helper3(root.left, sum, curList, res);
		helper3(root.right, sum, curList, res);
		curList.remove(curList.size()-1);		//why just need once? comments 
	}
	
	//iterate
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null)
			return res;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Deque<Integer> level = new LinkedList<Integer>();
		level.offer(1);
		
		List<Integer> curList = new LinkedList<Integer>();
		int curSum = 0;

		while(!queue.isEmpty()) {
			TreeNode tmp = queue.pollLast();
			int curLevel = level.pollLast();
			curSum = curSum + tmp.val;
			
			// remove list elements
			while(curList.size() >= curLevel) {
				curSum = curSum - curList.get(curList.size()-1);
				curList.remove(curList.size() - 1);
			}
			curList.add(tmp.val);	//need to remove one node before add to the curList
			
			if(tmp.left == null && tmp.right == null && curSum == sum) {
				res.add(new LinkedList<Integer>(curList));
			}
			if(tmp.right != null) {
				queue.offer(tmp.right);
				level.offer(curLevel+1);
			}
			if(tmp.left != null) {
				queue.offer(tmp.left);
				level.offer(curLevel+1);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n113_Path_Sum_II obj = new n113_Path_Sum_II();
		TreeNode p1 = obj.new TreeNode(5);
		TreeNode p2 = obj.new TreeNode(4);
		TreeNode p3 = obj.new TreeNode(8);
		TreeNode p4 = obj.new TreeNode(11);
		TreeNode p5 = obj.new TreeNode(13);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(7);
		TreeNode p8 = obj.new TreeNode(2);
		TreeNode p9 = obj.new TreeNode(5);
		TreeNode p10 = obj.new TreeNode(1);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7;
		p4.right = p8;
		p6.left = p9;
		p6.right = p10;
		
		System.out.println(obj.pathSum(p1, 22));
		System.out.println(obj.pathSum2(p1, 22));
		System.out.println(obj.pathSum3(p1, 22));
	}
}
