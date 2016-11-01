package LeetCode;

public class n226_Invert_Binary_Tree {
	/*
	 *      
	 4
   /   \
  2     7
 / \   / \				             
1   3 6   9

to 
	 4
   /   \
  7     2
 / \   / \				             
9   6 3   1
	 */
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return root;
		
		TreeNode l = root.left;				//swap
		root.left = invertTree(root.right);
		root.right = l;
		
		return root;
	}
	
	public static void main(String[] args) {
		n226_Invert_Binary_Tree obj = new n226_Invert_Binary_Tree();
		TreeNode t1 = obj.new TreeNode(4);
		TreeNode t2 = obj.new TreeNode(2);
		TreeNode t3 = obj.new TreeNode(7);
		TreeNode t4 = obj.new TreeNode(1);
		TreeNode t5 = obj.new TreeNode(3);
		TreeNode t6 = obj.new TreeNode(6);
		TreeNode t7 = obj.new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		System.out.println(t1.val + " " + t1.left.val + " " + t1.right.val);
		System.out.println(obj.invertTree(t1).left.val);
	}
}