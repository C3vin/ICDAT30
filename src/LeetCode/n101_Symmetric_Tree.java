package LeetCode;

public class n101_Symmetric_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetricTree(root.left, root.right);
	}
	//recursively 
	private boolean isSymmetricTree(TreeNode left, TreeNode right) {
		if(left == null && right == null) 
			return true;
		else if (left == null || right == null) 
			return false;

		if(left.val == right.val) {
			if(isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left))
				return true;
		}
		else 
			return false;
		return false;
	}

	//iteratively
	public boolean isSymmetric2(TreeNode root) {
		return false;
		//TODO: 
	}
	
	public static void main(String[] args) {
		n101_Symmetric_Tree obj = new n101_Symmetric_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(2);
		TreeNode p4 = obj.new TreeNode(3);
		TreeNode p5 = obj.new TreeNode(4);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(3);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.isSymmetric(p1));
	}
}
