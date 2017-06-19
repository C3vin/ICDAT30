package DSA.c6;

public class Q28_CheckMirrors {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}

	public boolean areMirrors(TreeNode root1, TreeNode root2) {
		// Base case : Both empty 
		if(root1 == null && root2 == null)
			return true;
		
		// If only one is empty
		if(root1 == null || root2 == null)
			return false;

		/* Both non-empty (off course), compare them recursively
        Note that in recursive calls, we pass left
        of one tree and right of other tree */
		return areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
	}

	public static void main(String[] args) {
		Q28_CheckMirrors obj = new Q28_CheckMirrors();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		p2.left = p4;

		TreeNode q1 = obj.new TreeNode(1);
		TreeNode q2 = obj.new TreeNode(3);
		TreeNode q3 = obj.new TreeNode(2);
		TreeNode q6 = obj.new TreeNode(5);
		TreeNode q7 = obj.new TreeNode(4);
		q1.left = q2;
		q1.right = q3;
		q3.right = q7;
		q3.left = q6;

		System.out.println(obj.areMirrors(p1, q1));
	}
}
