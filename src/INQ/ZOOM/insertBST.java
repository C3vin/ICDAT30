package INQ.ZOOM;

import java.util.ArrayList;
import java.util.List;

public class insertBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x; 
		}
	}

	TreeNode root;
	void insert(int key) { 
		root = insertRec(root, key); 
	} 

	/* A recursive function to insert a new key in BST */
	TreeNode insertRec(TreeNode root, int key) { 

		/* If the tree is empty, return a new node */
		if(root == null) { 
			root = new TreeNode(key); 
			return root; 
		} 

		/* Otherwise, recur down the tree */
		if(key < root.val) 
			root.left = insertRec(root.left, key); 
		else if(key > root.val) 
			root.right = insertRec(root.right, key); 

		/* return the (unchanged) node pointer */
		return root; 
	} 

	// This method mainly calls InorderRec() 
	void inorder()  { 
		inorderRec(root); 
	} 

	// A utility function to do inorder traversal of BST 
	void inorderRec(TreeNode root) { 
		if (root != null) { 
			inorderRec(root.left); 
			System.out.println(root.val); 
			inorderRec(root.right); 
		} 
	} 

	public static void main(String[] args) {
		insertBST obj = new insertBST();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		p1.right = p2;
		p2.left = p3;
		obj.insert(50); 
		obj.insert(30); 
		obj.insert(20); 
		obj.insert(40); 
		obj.insert(70); 
		obj.insert(60); 
		obj.insert(80); 

		obj.inorder();
	}
}
