package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class n112_Path_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}

	//Recursion
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		
		if(root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		
		//F: || not &&
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	//BFS
	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Queue<Integer> queueSum = new LinkedList<Integer>();
		queueSum.offer(root.val);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				int curSum = queueSum.poll();
				
				if(currentNode.left == null && currentNode.right == null && curSum == sum) {
					return true;
				}
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
					queueSum.offer(curSum + currentNode.left.val);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
					queueSum.offer(curSum + currentNode.right.val);
				}
			}
		}
		return false;
	}
	
	//DFS
	public boolean hasPathSum3(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> stackSum = new Stack<Integer>();
		//TreeNode cur = root;
		int curSum = 0;
		
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				curSum = curSum + root.val;
				stackSum.push(curSum);
				root = root.left;
			} else {
				root = stack.pop();
				curSum = stackSum.pop();
				if(root.left == null && root.right == null && curSum == sum) {
					return true;
				}
				root = root.right;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n112_Path_Sum obj = new n112_Path_Sum();
		TreeNode p1 = obj.new TreeNode(5);
		TreeNode p2 = obj.new TreeNode(4);
		TreeNode p3 = obj.new TreeNode(8);
		TreeNode p4 = obj.new TreeNode(11);
		TreeNode p5 = obj.new TreeNode(13);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(7);
		TreeNode p8 = obj.new TreeNode(2);
		TreeNode p9 = obj.new TreeNode(1);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7;
		p4.right = p8;
		p6.right = p9;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val + " " +p4.left.val + " " + p4.right.val + " " + p6.right.val);

		System.out.println(obj.hasPathSum(p1, 22));
		System.out.println(obj.hasPathSum2(p1, 22));
		System.out.println(obj.hasPathSum3(p1, 22));
	}
}
