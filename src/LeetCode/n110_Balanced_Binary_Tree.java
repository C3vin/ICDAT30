package LeetCode;

public class n110_Balanced_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	public boolean isBalanced(TreeNode root) {
		if(helper(root) == -1)
			return false;

		return true;
	}
	private int helper(TreeNode root) {
		if(root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		
		if(left == -1 || right == -1 || Math.abs(left - right) > 1)
			return -1;
		
		return Math.max(left, right) + 1;
	}
	public static void main(String[] args) {
		n110_Balanced_Binary_Tree obj = new n110_Balanced_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7; 	//if this, will be false
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val);

		System.out.println(obj.isBalanced(p1));
	}
}
