package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n145_Binary_Tree_Postorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if(root == null) return;

		helper(root.right, res);
		helper(root.left, res);
		res.add(root.val);
	}

	public static void main(String[] args) {
		n145_Binary_Tree_Postorder_Traversal obj = new n145_Binary_Tree_Postorder_Traversal();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		p1.right = p2;
		p2.left = p3;

		System.out.println(obj.postorderTraversal(p1));
	}
}
