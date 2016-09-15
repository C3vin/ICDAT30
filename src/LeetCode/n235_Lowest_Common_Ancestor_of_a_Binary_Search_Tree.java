package LeetCode;

public class n235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val < q.val) { 
			return root;
		} else if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}

	public static void main(String[] args) {
		n235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree obj = new n235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
		TreeNode p1 = obj.new TreeNode(6);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(8);
		TreeNode p4 = obj.new TreeNode(0);
		TreeNode p5 = obj.new TreeNode(4);
		TreeNode p6 = obj.new TreeNode(7);
		TreeNode p7 = obj.new TreeNode(9);
		TreeNode p8 = obj.new TreeNode(3);
		TreeNode p9 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;
		p5.left = p8;
		p5.right = p9;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val 
				+ " " + p3.left.val + " " +p3.right.val);
		
		System.out.println(obj.lowestCommonAncestor(p1, p2, p3).val);
		System.out.println(obj.lowestCommonAncestor(p1, p2, p5).val);
	}
}
