package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class n102_BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	
	//BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> node = new ArrayList<Integer>(); 				//Need 
			for(int i=0; i<levelSize; i++) {
				TreeNode tmp = queue.poll();
				if(tmp != null) {
					node.add(tmp.val);
				}
				if(tmp.left != null) {
					queue.offer(tmp.left);
				}
				if(tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			res.add(node);												//No need to new again!
		}
		return res;
	}
	
	//DFS
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		DFS(root, 0, res);
		
		return res;
	}
	private void DFS(TreeNode root, int level, List<List<Integer>> res) {
		if(root == null) {
			return;
		}
		//level: 0->1->2->2->1->2->2
		if(res.size() <= level) {				//in order to let get() working
			res.add(new ArrayList<Integer>());
		}
		
		res.get(level).add(root.val);
		
		DFS(root.left, level+1, res);
		DFS(root.right, level+1, res);
		
	}
	
	public static void main(String[] args) {
		//[3,9,20,null,null,15,7]
		/**
		 * [
  			[3],
  			[9,20],
  			[15,7]
		   ]
		 */
		n102_BinaryTreeLevelOrderTraversal obj = new n102_BinaryTreeLevelOrderTraversal();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(null);
		TreeNode p5 = obj.new TreeNode(null);
		TreeNode p6 = obj.new TreeNode(15);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;

		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.v + " " + p2.right.v + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.levelOrder(p1));
		System.out.println(obj.levelOrder2(p1));
	}
}
