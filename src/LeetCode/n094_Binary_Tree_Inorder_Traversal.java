package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class n094_Binary_Tree_Inorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	//Recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if(root == null) 
			return;
		
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}

	//iterate
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();  
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();  

		while(root != null || !stack.isEmpty()) //F: Need while!!!
			if(root != null) {   
				stack.push(root);
				root = root.left;
			} 
			else {
				root = stack.pop();  //F: need root
				res.add(root.val);
				root = root.right;
			}
		return res;
	}

	public static void main(String[] args) {
		n094_Binary_Tree_Inorder_Traversal obj = new n094_Binary_Tree_Inorder_Traversal();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		p1.right = p2;
		p2.left = p3;

		System.out.println(obj.inorderTraversal(p1));
		System.out.println(obj.inorderTraversal2(p1));
	}
}
