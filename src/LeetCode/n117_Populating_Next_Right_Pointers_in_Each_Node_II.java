package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.n116_Populating_Next_Right_Pointers_in_Each_Node.Node;

/*
Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer 
should be set to NULL.
Initially, all next pointers are set to NULL.
Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Example 1:
Given the following binary tree,
          1
        /  \
       2    3
      / \  / \
     4  5     7
After calling your function, the tree should look like:
         1 -> NULL
        /  \
       2 -> 3 -> NULL
      / \  / \
     4->5----->7 -> NULL
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Constraints:
The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100
 */
public class n117_Populating_Next_Right_Pointers_in_Each_Node_II {
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
	
	//BFS same as LC116 not good!
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
	
	//Same as LC 117 [LC 116 - LC 117] 2020 !!!
	public Node connect3(Node root) {
		Node dummyHead = new Node(0);
		Node pre = dummyHead;
		Node cur = root;
		
		while(cur != null) {
			if(cur.left != null) {
				pre.next = cur.left;
				pre = pre.next;
			}
			
			if(cur.right != null) {
				pre.next = cur.right;
				pre = pre.next;
			}
			
			cur = cur.next;
			
			if(cur == null) {
				pre = dummyHead;			//update the pre pointer
				cur = dummyHead.next;		//update cur, d(0)-rest of the tree we made 
				dummyHead.next = null;		//clean the d.next 
			}
		}
		
		return root;
	}
	
	//Same as LC 116 [LC 116 - LC 117]
	public Node connect2(Node root) {
		if(root == null) {
			return root;
		}
		
		Node cur = root;
		Node start = null;
		Node end = null;
		
		while(cur != null) {
			while(cur != null) {
				if(cur.left != null) {
					if(end != null) {
						end.next = cur.left;
					} else {
						start = cur.left;
					}
					end = cur.left;
				}
				if(cur.right != null) {
					if(end != null) {
						end.next = cur.right;
					} else {
						start = cur.right;
					}
					end = cur.right;
				}
				
				cur = cur.next;
			}
			//reset
			cur = start;
			start = null;
			end = null;
		}
		return root;
	}
	
	public static void main(String[] args) {
		n117_Populating_Next_Right_Pointers_in_Each_Node_II obj = new n117_Populating_Next_Right_Pointers_in_Each_Node_II();
		Node p1 = obj.new Node(1);
		Node p2 = obj.new Node(2);
		Node p3 = obj.new Node(3);
		Node p4 = obj.new Node(4);
		Node p5 = obj.new Node(5);
		//Node p6 = obj.new Node(6);
		Node p7 = obj.new Node(7);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		//p3.left = p6;
		p3.right = p7;
		
	/*	System.out.println(obj.connect(p1));
		System.out.println(obj.connect2(p1));*/
		System.out.println(obj.connect3(p1));
	}
}
