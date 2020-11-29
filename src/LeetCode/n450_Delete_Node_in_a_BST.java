package LeetCode;

/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?

Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Example 3:
Input: root = [], key = 0
Output: []
 */
public class n450_Delete_Node_in_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) {
			return null;
		}
		
		if(root.val == key) {
			//case 1 & case 2
			if(root.left == null) {
				return root.right;
			} 
			if(root.right == null) {
				return root.left;
			}
			//case 3
			TreeNode minNode = getMin(root.right);
			root.val = minNode.val;
			root.right = deleteNode(root.right, minNode.val);
			
		} else if(root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if(root.val < key) {
			root.right = deleteNode(root.right, key);
		}
		
		return root;
	}
 	
	private TreeNode getMin(TreeNode root) {
		while(root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		n450_Delete_Node_in_a_BST obj = new n450_Delete_Node_in_a_BST();
		TreeNode p1 = new TreeNode(5);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(6);
		TreeNode p4 = new TreeNode(2);
		TreeNode p5 = new TreeNode(4);
		TreeNode p6 = new TreeNode(7);

		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = null;
		p3.right = p6;

		System.out.println(obj.deleteNode(p1 , 3));
	}
}
