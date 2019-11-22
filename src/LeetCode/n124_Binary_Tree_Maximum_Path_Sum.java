package LeetCode;

/*
Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node 
in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

https://bangbingsyb.blogspot.com/2014/11/leetcode-binary-tree-maximum-path-sum.html
https://www.cnblogs.com/grandyang/p/4280120.html
https://leetcode.wang/leetcode-124-Binary-Tree-Maximum-Path-Sum.html
 */
public class n124_Binary_Tree_Maximum_Path_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int max = Integer.MIN_VALUE;		//global variable
	public int maxPathSum(TreeNode root) {
		helper(root);
		
		return max;
	}
	private int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = Math.max(helper(root.left), 0);			//F: ignore negative  
		int right = Math.max(helper(root.right), 0);
		
		max = Math.max(max, root.val + left + right);
		
		//only need the current node with left OR right
		return root.val + Math.max(left, right);
	}
	
	public static void main(String[] args) {
		n124_Binary_Tree_Maximum_Path_Sum obj = new n124_Binary_Tree_Maximum_Path_Sum();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		p1.left = p2;
		p1.right = p3;
		System.out.println(obj.maxPathSum(p1));
	}
}
