package LeetCode;

public class n617_Merge_Two_Binary_Trees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode res = null;
		if(t1 == null)
			return t2;
		if(t2 == null)
			return t1;
		
		res = new TreeNode(t1.val + t2.val);			//here we use new!
		res.left = mergeTrees(t1.left, t2.left);
		res.right = mergeTrees(t1.right, t2.right);
		
		return res;
	}
	public static void main(String[] args) {
		n617_Merge_Two_Binary_Trees obj = new n617_Merge_Two_Binary_Trees();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(3);
		TreeNode p3 = obj.new TreeNode(2);
		TreeNode p4 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.right = p4;
		
		TreeNode q1 = obj.new TreeNode(2);
		TreeNode q2 = obj.new TreeNode(1);
		TreeNode q3 = obj.new TreeNode(3);
		TreeNode q4 = obj.new TreeNode(4);
		TreeNode q5 = obj.new TreeNode(7);
		q1.left = q2;
		q1.right = q3;
		q2.left = q4;
		q3.right = q5;
		
		System.out.println(obj.mergeTrees(p1, q1));
	}
}
