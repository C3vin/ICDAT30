package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

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
Given the following perfect binary tree,
          1
        /  \
       2    3
      / \  / \
     4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
        /  \
       2 -> 3 -> NULL
      / \  / \
     4->5->6->7 -> NULL
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
	//BFS 
	public Node connect(Node root) {
		if(root == null) {
			return root;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			Node pre = null;
			
			for(int i=0; i<levelSize; i++) {
				Node currentNode = queue.poll();
				
				if(i > 0) {
					pre.next = currentNode;
				}
				pre = currentNode;
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
		}
		return root;
	}
	
	//space:O(1)
	public Node connect2(Node root) {
		if(root == null) {
			return root;
		}
		
		Node start = root;
		Node pre = root;
		Node cur = null;
		
		while(pre.left != null) {
			if(cur == null) {
				pre.left.next = pre.right;
				
				pre = start.left;
				cur = start.right;
				start = pre;
			} else {
				pre.left.next = pre.right;
				pre.right.next = cur.left;
				pre = cur;	//pre = pre.next;
				cur = cur.next;
			}
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		n116_Populating_Next_Right_Pointers_in_Each_Node obj = new n116_Populating_Next_Right_Pointers_in_Each_Node();
		Node p1 = obj.new Node(1);
		Node p2 = obj.new Node(2);
		Node p3 = obj.new Node(3);
		Node p4 = obj.new Node(4);
		Node p5 = obj.new Node(5);
		Node p6 = obj.new Node(6);
		Node p7 = obj.new Node(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;
		p3.right = p7;
		
		System.out.println(obj.connect(p1));
		System.out.println(obj.connect2(p1));
	}
}
