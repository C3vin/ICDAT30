package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class n113_Path_Sum_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null)
			return res;
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Deque<Integer> value = new LinkedList<Integer>();
		value.offer(root.val);

		List<Integer> cur = new LinkedList<Integer>();
		int curSum = 0;

		while(!queue.isEmpty()) {
			TreeNode tmp = queue.pollLast();
			int sumValue = tmp.val;
			curSum = curSum + sumValue;
			cur.add(tmp.val);
			if(curSum > sum) {
				//System.out.println("@");
				curSum = curSum - sumValue;
				cur.remove(cur.size() - 1);
			}

			if(tmp.left == null && tmp.right == null && curSum == sum) {
				res.add(new LinkedList<Integer>(cur));
				System.out.println("Got!        " + cur);
			}
			if(tmp.right != null) {
				queue.offer(tmp.right);
				//value.offer(sumValue + tmp.right.val);
			}
			if(tmp.left != null) {
				queue.offer(tmp.left);
				//value.offer(sumValue + tmp.left.val);
			}
		}
		return res;
	}
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> levelStack = new Stack<Integer>();

		List<Integer> curList = new ArrayList<Integer>();

		nodeStack.push(root);
		levelStack.push(1);

		int curSum = 0;

		while (!nodeStack.isEmpty()) {
			System.out.println("levelstack: " +levelStack);
			TreeNode curNode = nodeStack.pop();
			int curLevel = levelStack.pop();
			curSum += curNode.val;

			System.out.println("@1: "+curList + " : " + curNode.val);
			// remove list elements
			while (curList.size() >= curLevel) {
				//System.out.println("curLevel!: " + curLevel);
				curSum -= curList.get(curList.size() - 1);
				curList.remove(curList.size() - 1);
				System.out.println("#: "+curList);
			}

			curList.add(curNode.val);
			// if is a leaf node
			if (curNode.left == null && curNode.right == null && curSum == sum) {
				result.add(new ArrayList<Integer>(curList));
			}

			if (curNode.right != null) {
				nodeStack.push(curNode.right);
				levelStack.push(curLevel + 1);
			}

			if (curNode.left != null) {
				nodeStack.push(curNode.left);
				levelStack.push(curLevel + 1);
			}
		}
		return result;
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
		/*		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val + " " +p4.left.val + " " + p4.right.val + " " + p6.left.val + " " + p6.right.val);
		 */
		System.out.println(obj.pathSum(p1, 22));
		//System.out.println(obj.pathSum2(p1, 22));
	}
}
