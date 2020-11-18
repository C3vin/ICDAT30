package LeetCode;

/*
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST 
is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

Example 2:
Input: root = [0,null,1]
Output: [1,null,1]

Example 3:
Input: root = [1,0,2]
Output: [3,3,2]

Example 4:
Input: root = [3,2,4,1]
 */
public class n538_Convert_BST_to_Greater_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public TreeNode convertBST(TreeNode root) {
		helper(root);
		return root;
	}
	
	int sum = 0;
	private void helper(TreeNode root) {
		if(root == null) {
			return;
		}
		
		helper(root.right);				//chnage order from inorder to descending, swap left & right order
		
		sum = sum + root.val;
		root.val = sum;
		
		helper(root.left);
	}
	
	public static void main(String[] args) {
		n538_Convert_BST_to_Greater_Tree obj = new n538_Convert_BST_to_Greater_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(0);
		TreeNode p3 = obj.new TreeNode(2);
		
		p1.left = p2;
		p1.right = p3;
		
		System.out.println(obj.convertBST(p1));
	}
}
