package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

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

	//dfs
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		
		if(root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Queue<Integer> value = new LinkedList<Integer>();
		value.offer(root.val);

		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			int sumValue = value.poll();

			if(currentNode.left == null && currentNode.right == null && sumValue == sum) 
				return true;

			if(currentNode.left != null) {
				queue.offer(currentNode.left);
				value.offer(sumValue + currentNode.left.val);
			}
			if(currentNode.right != null) {
				queue.offer(currentNode.right);
				value.offer(sumValue + currentNode.right.val);
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
	}
}
