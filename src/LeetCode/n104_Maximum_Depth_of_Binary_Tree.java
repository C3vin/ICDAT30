package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class n104_Maximum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//Recursive 
	//DFS
	//O(n) O(logn)
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;		
		}
		int leftDepth = maxDepth(root.left); 
		int rightDepth = maxDepth(root.right);

		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	//Non-recursive
	//BFS		//[LC104 - LC111 template]
	public int maxDepth2(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		int level = 0;
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			level++;
		}
		return level;
	}

	public static void main(String[] args) {
		n104_Maximum_Depth_of_Binary_Tree obj = new n104_Maximum_Depth_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		//TreeNode p4 = obj.new TreeNode(null);
		//TreeNode p5 = obj.new TreeNode(null);
		TreeNode p6 = obj.new TreeNode(15);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		//p2.right = p5;
		//p2.left = p4;
		p3.right = p7;
		p3.left = p6;
		//System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val 
		//	+ " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.maxDepth(p1));
		System.out.println(obj.maxDepth2(p1));
	}
}
