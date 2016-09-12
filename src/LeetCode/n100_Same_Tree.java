package LeetCode;

public class n100_Same_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) 
			return true;
		else if(p == null || q == null)
			return false;
		
		if(p.val == q.val) 
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else 
			return false;
	}
	
	public static void main(String[] args) {
		n100_Same_Tree obj = new n100_Same_Tree();
		TreeNode p1 = obj.new TreeNode(2);
		TreeNode p2 = obj.new TreeNode(1);
		TreeNode p3 = obj.new TreeNode(3);
		p1.left = p2;
		p1.right = p3;
		System.out.println(p1.left.val + " " + p1.val + " " + p1.right.val);
		TreeNode q1 = obj.new TreeNode(3);
		TreeNode q2 = obj.new TreeNode(1);
		TreeNode q3 = obj.new TreeNode(4);
		q1.left = q2;
		q1.right = q3;
		System.out.println(q1.left.val + " " + q1.val + " " + q1.right.val);
		System.out.println(obj.isSameTree(p1, q1));
	}
}
