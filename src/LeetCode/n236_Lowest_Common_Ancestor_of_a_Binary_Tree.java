package LeetCode;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node 
in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
		   3
		 /   \
		5     1
	   / \   / \
	  6  2  0  8
	    / \
	   7  4
	   
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */

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

		TreeNode left = lowestCommonAncestor(root.left, p, q);		//need TreeNode
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		//nodes are each on a separate branch
		if(left != null && right!= null)
			return root;
		
		//either one node is on one branch, or none was found in any of the branches 
		return left == null ? right : left;
	}
	
	//better
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor2(root.left, p, q);
		TreeNode right = lowestCommonAncestor2(root.right, p, q);
		
		//can't find in the left tree, must in the right tree
		if(left == null) {
			return right;
		}

		//can't find in the right tree, must in the left tree
		if(right == null) {
			return left;
		}
		
		//not in left or right, must node root
		return root;
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
		
		System.out.println(obj.lowestCommonAncestor2(p1, p2, p3).val);
		System.out.println(obj.lowestCommonAncestor2(p1, p8, p9).val);	//this change p
	}
}