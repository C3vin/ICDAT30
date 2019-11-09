package LeetCode;

import java.util.ArrayList;
import java.util.List;

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
		
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
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
	}
}
