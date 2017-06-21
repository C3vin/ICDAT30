package DSA.c6;

public class Q27_MirrorOfBinaryTree {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public TreeNode mirrorOfBinaryTree(TreeNode root) {
		if(root == null) return root;

		TreeNode tmp = null;
		if(root != null) {		//no need to test == null in here
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);

			//swap
			tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
		return root;
	}
	public static void main(String[] args) {
		Q27_MirrorOfBinaryTree obj = new Q27_MirrorOfBinaryTree();
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
		/*p3.right = p7;
		p3.left = p6;*/

		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val);
		TreeNode ans = obj.mirrorOfBinaryTree(p1);
		System.out.println(ans.val + " " + ans.left.val + " " +ans.right.val + " " + ans.right.left.val + " " + ans.right.right.val);
	}
}
