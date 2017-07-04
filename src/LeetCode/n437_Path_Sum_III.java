package LeetCode;

public class n437_Path_Sum_III {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	public int pathSum(TreeNode root, int sum) {
		if(root == null)
			return 0;
		return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	private int helper(TreeNode root, int sum) {
		int res = 0;
		if(root == null)
			return res;
		
		if(sum == root.val) {
			res = res + 1;
		}
		res = res + helper(root.left, sum - root.val);
		res = res + helper(root.right, sum - root.val);
		
		return res;
	}
	public static void main(String[] args) {
		n437_Path_Sum_III obj = new n437_Path_Sum_III();
		TreeNode p1 = obj.new TreeNode(10);
		TreeNode p2 = obj.new TreeNode(5);
		TreeNode p3 = obj.new TreeNode(-3);
		TreeNode p4 = obj.new TreeNode(3);
		TreeNode p5 = obj.new TreeNode(2);
		TreeNode p6 = obj.new TreeNode(11);
		TreeNode p7 = obj.new TreeNode(3);
		TreeNode p8 = obj.new TreeNode(-2);
		TreeNode p9 = obj.new TreeNode(1);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.right = p6;
		p4.left = p7;
		p4.right = p8;
		p5.right = p9;
		
		System.out.println(obj.pathSum(p1, 8));
	}
}
