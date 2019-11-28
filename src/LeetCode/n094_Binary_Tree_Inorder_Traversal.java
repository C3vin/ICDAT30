package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class n094_Binary_Tree_Inorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	//Recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if(root == null) 
			return;
		
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}
	
	//Iteration
	//Stack approach
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();  
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  //Stack<TreeNode> stack = new Stack<TreeNode>();

		while(root != null || !stack.isEmpty()) //F: Need while!!!
			if(root != null) {   
				stack.push(root);
				root = root.left;
			} 
			else {
				root = stack.pop();  //F: need root
				res.add(root.val);
				root = root.right;
			}
		return res;
	}

	//https://leetcode.wang/leetCode-94-Binary-Tree-Inorder-Traversal.html
	//Morris Traversal
	public List<Integer> inorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode cur = root;
		
		while(cur != null) {
			//case1
			if(cur.left == null) {
				res.add(cur.val);
				cur = cur.right;
			} else {
				//case 2
				TreeNode last = cur.left;
				while(last.right != null && last.right != cur) {
					last = last.right;  
				}
				//case2.1
				if(last.right == null) {
					last.right = cur;
					cur = cur.left;
				}
				//case2.2
				if(last.right == cur) {
					//last.right = null;
					res.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		n094_Binary_Tree_Inorder_Traversal obj = new n094_Binary_Tree_Inorder_Traversal();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		p1.right = p2;
		p2.left = p3;

		System.out.println(obj.inorderTraversal(p1));
		System.out.println(obj.inorderTraversal2(p1));
		System.out.println(obj.inorderTraversal3(p1));
	}
}
