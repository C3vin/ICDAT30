package LeetCode;

import java.util.Stack;

/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. 
The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False
 */
public class n173_Binary_Search_Tree_Iterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	Stack<TreeNode> stack;

	public n173_Binary_Search_Tree_Iterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while(root != null) {
			stack.push(root);
			root = root.left; 		//BST, smallest is on the left
		}
	}
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		int res = node.val;

		if(node.right != null) {			//need to check node.right first!!!
			node = node.right;

			while(node != null) {			//same as BST 
				stack.push(node);
				node = node.left;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode p1 = new TreeNode(7);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(15);
		TreeNode p4 = new TreeNode(9);
		TreeNode p5 = new TreeNode(20);

		p1.left = p2;
		p1.right = p3;
		p3.left = p4;
		p3.right = p5;
		n173_Binary_Search_Tree_Iterator obj = new n173_Binary_Search_Tree_Iterator(p1);
		System.out.println(obj.next() +":"+ obj.next() +":"+ obj.hasNext() +":"+ obj.next() 
		+":"+ obj.hasNext() +":"+ obj.next() +":"+ obj.hasNext() +":"+ obj.next() +":"+ obj.hasNext());
	}

}
