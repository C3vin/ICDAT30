package LeetCode;

import java.util.ArrayList;
import java.util.List;

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
public class n098_Validate_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isValidBST(TreeNode root) {
		/*List<Integer> pre = new ArrayList<Integer>();
		pre.add(null);
		return BSTHelper(root, pre);*/
		
		return BSTHelper(root);
	}

	private long vv = Long.MIN_VALUE;
	private boolean BSTHelper(TreeNode node) {
		if(node != null) {
			if(!BSTHelper(node.left)) 
				return false;
			
			if(node.val <= vv) 
				return false;
			else 
				vv = node.val;
			
			if(!BSTHelper(node.right)) 
				return false;
		}
		return true;
	}
	
	/*
	public boolean BSTHelper(TreeNode root, List<Integer> pre) {
	    if(root == null) return true;
	    
	    boolean left = BSTHelper(root.left, pre);
	    if(pre.get(0) != null && pre.get(0) >= root.val)
	        return false;
        pre.set(0, root.val);
        boolean right = BSTHelper(root.right, pre);
        
        return left && right;
	}*/

	public static void main(String[] args) {
		n098_Validate_Binary_Search_Tree obj = new n098_Validate_Binary_Search_Tree();
		TreeNode t1 = obj.new TreeNode(2);
		TreeNode t2 = obj.new TreeNode(1);
		TreeNode t3 = obj.new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		System.out.println(t1.val + " " + t1.left.val + " " + t1.right.val);
		System.out.println(obj.isValidBST(t1));
	}
}
