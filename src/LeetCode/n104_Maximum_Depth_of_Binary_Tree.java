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
	//sol1: Recursive 
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

	//O(n) O(logn)
	public int maxDepth2(TreeNode root) {
		if(root == null) {
			return 0;
		}

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<Integer> depths = new LinkedList<Integer>();

		stack.offer(root);
		depths.offer(1);

		int depth = 0;
		int currentDepth = 0;
		while(!stack.isEmpty()) {
			TreeNode currentNode = stack.pollLast();		//last element
			currentDepth = depths.pollLast();
			if(currentNode != null) {
				depth = Math.max(depth, currentDepth);
				if(currentNode.left != null) {
					stack.offer(currentNode.left);
					depths.offer(currentDepth+1);	
				}
				if(currentNode.right != null) {
					stack.offer(currentNode.right);
					depths.offer(currentDepth+1);	
				}
				/*stack.offer(currentNode.left);
				stack.offer(currentNode.right);
				depths.offer(currentDepth+1);				//left
				depths.offer(currentDepth+1);				//right
*/			}
		}
		return depth;
	}

	//sol3: Non-recursive
	//BFS
	public int maxDepth3(TreeNode root) {
		if(root == null) 
			return 0;

		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp != null) {
				if(tmp.left != null) 
					queue.offer(tmp.left);
				if(tmp.right != null)
					queue.offer(tmp.right);
			} else {
				depth++;
				if(!queue.isEmpty())
					queue.offer(null);
			}
		}
		return depth;
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
		System.out.println(obj.maxDepth3(p1));
	}
}
