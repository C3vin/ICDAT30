package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:

Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 */
public class n1161_Maximum_Level_Sum_of_a_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { 
			this.val = val; 
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int level = 1;
		int maxLevel = 0;
		int maxSum = Integer.MIN_VALUE;

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			int sum = 0;

			for(int i=0; i<levelSize; i++) {
				TreeNode curNode = queue.poll();
				sum = sum + curNode.val;

				if(curNode.left != null) {
					queue.offer(curNode.left);
				}
				if(curNode.right != null) {
					queue.offer(curNode.right);
				}
			}

			if(sum > maxSum) {
				maxSum = sum;
				maxLevel = level;
			}

			level++;
		}

		return maxLevel;
	}

	public static void main(String[] args) {
		n1161_Maximum_Level_Sum_of_a_Binary_Tree obj = new n1161_Maximum_Level_Sum_of_a_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(400);
		TreeNode p2 = obj.new TreeNode(250);
		TreeNode p3 = obj.new TreeNode(200);
		TreeNode p4 = obj.new TreeNode(150);
		TreeNode p5 = obj.new TreeNode(150);
		//		TreeNode p6 = obj.new TreeNode(null);
		//		TreeNode p7 = obj.new TreeNode(null);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = null;
		p3.right = null;
		System.out.println(obj.maxLevelSum(p1));
	}
}
