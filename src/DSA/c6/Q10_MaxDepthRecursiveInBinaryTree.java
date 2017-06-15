package DSA.c6;

public class Q10_MaxDepthRecursiveInBinaryTree {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}

	public int maxDepthRecursive(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftDepth = maxDepthRecursive(root.left);
		int rightDepth = maxDepthRecursive(root.right);
		
		return (leftDepth > rightDepth) ? leftDepth+1 : rightDepth+1; 	//no need if 
	}

	public static void main(String[] args) {
		Q10_MaxDepthRecursiveInBinaryTree obj = new Q10_MaxDepthRecursiveInBinaryTree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;

		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.maxDepthRecursive(p1));
	}
}
