package LeetCode;

/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Given the following tree [3,9,20,null,null,15,7]:
    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:
Given the following tree [1,2,2,3,3,null,null,4,4]:
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */
public class n110_Balanced_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	//O(n) O(n)
	public boolean isBalanced(TreeNode root) {
		if(helper(root) == -1)
			return false;

		return true;
	}
	//https://www.cnblogs.com/yrbbest/p/4437324.html
	//dfs bottom-up solution 
	private int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = helper(root.left);
		if(left == -1) {
			return -1;
		}
		
		int right = helper(root.right);
		if(right == -1) {
			return -1;
		}
		
		int diff = Math.abs(left-right);
		if(diff > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

	//bottom-up
	public boolean isBalanced2(TreeNode root) {
		if(root == null) {
			return true;
		}
		int leftDepth = helper2(root.left);
		int rightDepth = helper2(root.right);
		
		if(Math.abs(leftDepth - rightDepth) > 1) {
			return false;
		}
		
		return isBalanced2(root.left) && isBalanced2(root.right);
	}
	//LC104
	private int helper2(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = helper2(root.left);
		int rightDepth = helper2(root.right);
		
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public static void main(String[] args) {
		n110_Balanced_Binary_Tree obj = new n110_Balanced_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7; 	//if this, will be false
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val);

		System.out.println(obj.isBalanced(p1));
	}
}
