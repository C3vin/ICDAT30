package LeetCode;

import LeetCode.n098_Validate_Binary_Search_Tree.TreeNode;

/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

Example 1:
Input: [1,3,null,null,2]
   1
  /
 3
  \
   2
Output: [3,1,null,null,2]
   3
  /
 1
  \
   2

Example 2:
Input: [3,1,4,null,null,2]
  3
 / \
1   4
   /
  2
Output: [2,1,4,null,null,3]
  2
 / \
1   4
   /
  3

Follow up:
A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 */
public class n099_Recover_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public void recoverTree(TreeNode root) {

	}
	
	public static void main(String[] args) {
		n099_Recover_Binary_Search_Tree obj = new n099_Recover_Binary_Search_Tree();
		TreeNode t1 = obj.new TreeNode(2);
		TreeNode t2 = obj.new TreeNode(1);
		TreeNode t3 = obj.new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		obj.recoverTree(t1);
	}
}
