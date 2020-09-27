package LeetCode;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
import java.util.Stack;

public class n098_Validate_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//cs
	//O(n) O(n)
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		return helper(root, null, null);
	}
	
	//BST template 
	private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
		if(root == null) {
			return true;
		}
		
		if(min != null && root.val <= min.val) {
			return false;
		}
		
		if(max != null && root.val >= max.val) {
			return false;
		}
		
		return helper(root.left, min, root) && helper(root.right, root, max);
	}
	
/*	//need to use Integer for handle INF/-INF case, JAVA defaul auto-wrap 
	private boolean helper(TreeNode root, Integer min, Integer max) {
		if(root == null) {
			return true;
		}
		if(min != null && root.val <= min) {	//Integer can compare null
			return false;
		}
		if(max != null && root.val >= max) {
			return false;
		}
		//left Child: (bound, parent node)
		//right Child: (parent node, bound)
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
	*/
	//inorder approach
	//LC 94
	public boolean isValidBST2(TreeNode root) {
		if(root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				if(pre != null && pre.val >= root.val) {
					return false;
				}
				pre = root;
				root = root.right;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		n098_Validate_Binary_Search_Tree obj = new n098_Validate_Binary_Search_Tree();
		TreeNode t1 = obj.new TreeNode(2);
		TreeNode t2 = obj.new TreeNode(1);
		TreeNode t3 = obj.new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		System.out.println(t1.val + " " + t1.left.val + " " + t1.right.val);
		System.out.println(obj.isValidBST(t1));
		System.out.println(obj.isValidBST2(t1));
	}
}
