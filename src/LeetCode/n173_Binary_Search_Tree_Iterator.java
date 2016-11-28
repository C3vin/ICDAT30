package LeetCode;

import java.util.LinkedList;

public class n173_Binary_Search_Tree_Iterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	public n173_Binary_Search_Tree_Iterator(TreeNode root) {	
		while(root != null) {
			stack.push(root);
			root = root.left; 		//BST, smallest is on the left
		}
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	public int next() {
		TreeNode node = stack.pop();
		int res = node.val;
		
		if(node.right != null) {
			node = node.right;
			while(node != null) {			//same as BST 
				stack.push(node);
				node = node.left;
			}
		}
		return res;
	}
}
