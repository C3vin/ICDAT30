package LeetCode;

public class n236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	//https://segmentfault.com/a/1190000003509399
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) 
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right!= null)
			return root;
		
		return left == null ? right : left;

	}
	public static void main(String[] args) {
		n236_Lowest_Common_Ancestor_of_a_Binary_Tree obj = new n236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(5);
		TreeNode p3 = obj.new TreeNode(1);
		TreeNode p4 = obj.new TreeNode(6);
		TreeNode p5 = obj.new TreeNode(2);
		TreeNode p6 = obj.new TreeNode(0);
		TreeNode p7 = obj.new TreeNode(8);
		TreeNode p8 = obj.new TreeNode(7);
		TreeNode p9 = obj.new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;
		p3.right = p7;
		p5.left = p8;
		p5.right = p9;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val 
				+ " " + p3.left.val + " " +p3.right.val);

		System.out.println(obj.lowestCommonAncestor(p1, p2, p3).val);
		System.out.println(obj.lowestCommonAncestor(p1, p2, p9).val);
	}
}