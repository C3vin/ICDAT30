package LeetCode;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node 
in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
		   6
		 /   \
		2     8
	   / \   / \
	  0  4  7  9
	    / \
	   3  5
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class n235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	//LC236 is Binary Tree. LC235 Binary Search Tree (left node < right node)
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
