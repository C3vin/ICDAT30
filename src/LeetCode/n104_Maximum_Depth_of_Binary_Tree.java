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
	public int maxDepth(TreeNode root) {
		if(root == null) 
			return 0;			
		int left = maxDepth(root.left); 
		int right = maxDepth(root.right);

		int res = Math.max(left, right)+1;	//depth+1(root)
		return res;
	}
	//sol2: Non-recursive
	public int maxDepth2(TreeNode root) {
		if(root == null)  return 0;

		int level = 0;  
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
		queue.add(root);  	//only add one node, size = 1 e.g. root
		int curNum = 1; 	//num of nodes left in current level  
		int nextNum = 0; 	//num of nodes in next level  

		while(!queue.isEmpty()) {  
			TreeNode n = queue.poll();  	//poll one node from queue
			curNum--;  						//curNum--
			if(n.left!=null) {  
				queue.add(n.left);  
				nextNum++;  
			}  
			if(n.right!=null) {  
				queue.add(n.right);  
				nextNum++;  
			}  
			if(curNum == 0) {  			//if no curNum, reset
				curNum = nextNum;  
				nextNum = 0;  
				level++;  
			}  
		}  
		return level;  
	}
	//sol3: Non-recursive
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
	public int maxDepth4(TreeNode root) {
		if(root == null) {
			return 0;
		}
		System.out.println(root.val);
		return Math.max(maxDepth4(root.left), maxDepth4(root.right)) + 1;
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
		System.out.println(obj.maxDepth3(p1));
		System.out.println(obj.maxDepth4(p1));
	}
}
