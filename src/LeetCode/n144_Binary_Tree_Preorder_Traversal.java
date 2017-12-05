package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class n144_Binary_Tree_Preorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//Recursion
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if(root == null) return;

		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}

	//iterate
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();	
		
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.add(root);
				res.add(root.val);			//?
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n144_Binary_Tree_Preorder_Traversal obj = new n144_Binary_Tree_Preorder_Traversal();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		p1.right = p2;
		p2.left = p3;

		System.out.println(obj.preorderTraversal(p1));
		System.out.println(obj.preorderTraversal2(p1));
	}
}
