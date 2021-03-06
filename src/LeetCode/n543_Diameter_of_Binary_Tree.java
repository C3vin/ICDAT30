package LeetCode;

/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the 
length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class n543_Diameter_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		helper(root);
		return max;
	}
	private int helper(TreeNode root) {			
		if(root == null)
			return 0;

		int left = helper(root.left);
		int right = helper(root.right);
		
		max = Math.max(max, left + right);			//update max

		//calculate the depth of a node in the usual way: max(depth of node.left, depth of node.right) + 1
		return Math.max(left, right) + 1;			//update level	
	}

/*	4 left: 0 right: 0
	5 left: 0 right: 0
	2 left: 1 right: 1
	3 left: 0 right: 0
	1 left: 2 right: 1 */
	
	public static void main(String[] args) {
		n543_Diameter_of_Binary_Tree obj = new n543_Diameter_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;

		System.out.println(obj.diameterOfBinaryTree(p1));
	}
}
