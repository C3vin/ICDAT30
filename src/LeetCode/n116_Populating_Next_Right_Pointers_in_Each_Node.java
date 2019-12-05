package LeetCode;

import LeetCode.n102_BinaryTreeLevelOrderTraversal.TreeNode;

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Follow up:
You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, 
just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class n116_Populating_Next_Right_Pointers_in_Each_Node {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
	public Node connect(Node root) {

	}
	
	public static void main(String[] args) {
		n116_Populating_Next_Right_Pointers_in_Each_Node obj = new n116_Populating_Next_Right_Pointers_in_Each_Node();
		Node p1 = obj.new Node(3);
		Node p2 = obj.new Node(9);
		Node p3 = obj.new Node(20);
		Node p4 = obj.new Node(null);
		Node p5 = obj.new Node(null);
		Node p6 = obj.new Node(15);
		Node p7 = obj.new Node(7);
		
		
		System.out.println(obj.connect(root));
	}
}
