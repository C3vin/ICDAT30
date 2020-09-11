package LeetCode;

/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Example 2:
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

Example 3:
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */
public class n100_Same_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		}
		if(p == null || q == null) {
			return false;
		}
		
		if(p.val != q.val) {
			return false;
		}
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	public static void main(String[] args) {
		n100_Same_Tree obj = new n100_Same_Tree();
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(1);
		TreeNode p3 = new TreeNode(3);
		p1.left = p2;
		p1.right = p3;
		System.out.println(p1.left.val + " " + p1.val + " " + p1.right.val);
		TreeNode q1 = new TreeNode(3);
		TreeNode q2 = new TreeNode(1);
		TreeNode q3 = new TreeNode(4);
		q1.left = q2;
		q1.right = q3;
		System.out.println(q1.left.val + " " + q1.val + " " + q1.right.val);
		System.out.println(obj.isSameTree(p1, q1));
	}
}
