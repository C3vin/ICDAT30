package LeetCode;

import java.util.Stack;

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
	//inorder approach
	//after find the reverse order, change to original order. small to larger
	//case1: [13245], reverse order: 32. case2: [15342], reverse order: 53 & 42
	TreeNode first = null;					//F: first
	TreeNode second = null;					//F: second
	public void recoverTree(TreeNode root) {
		helper(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	TreeNode pre = null;					//F: pre
	private void helper(TreeNode root) {
		if(root == null) {
			return;
		}
		//inorder
		helper(root.left);

		if(pre != null && pre.val >= root.val) {
			if(first == null) {     //find first time reverse order
				first = pre;
				second = root;
			} else {                //find second time reverse order
				second = root;
			}
		}
		pre = root;

		helper(root.right);
	}

	TreeNode f = null;
	TreeNode s = null;
	public void recoverTree2(TreeNode root) {
		helper2(root);
		int tmp = f.val;
		f.val = s.val;
		s.val = tmp;
	}
	private void helper2(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;			//F: pre

		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();

				if(pre != null && pre.val >= root.val) {
					if(f == null) {
						f = pre;
						s = root;
					} else {
						s = root;
					}
				}

				pre = root;
				root = root.right;
			}
		}
	}

	public static void main(String[] args) {
		n099_Recover_Binary_Search_Tree obj = new n099_Recover_Binary_Search_Tree();
		TreeNode t1 = obj.new TreeNode(1);
		TreeNode t2 = obj.new TreeNode(3);
		TreeNode t3 = obj.new TreeNode(2);
		t1.left = t3;
		t1.right = null;
		t2.left = null;
		t2.right = t2;
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(3);
		TreeNode p3 = obj.new TreeNode(2);
		p1.left = p3;
		p1.right = null;
		p2.left = null;
		p2.right = p2;
		obj.recoverTree(t1);
		obj.recoverTree2(p1);
	}
}
