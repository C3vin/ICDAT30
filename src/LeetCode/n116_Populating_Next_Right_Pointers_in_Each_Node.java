package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.n117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;

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
	
	//BFS  not good
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
	
	//Same as LC117 [LC116 - LC117] 2020 !!!
	public Node connect4(Node root) {
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

	//BT template, but prefer use //Same as LC117 [LC116 - LC117] 2020 !!! for both
	public Node connect3(Node root) {
		if(root == null) {
			return root;
		}
		if(root.left != null) {
			root.left.next = root.right;
		}
		if(root.next != null && root.right != null) {
			root.right.next = root.next.left;
		}
		
		connect3(root.left);
		connect3(root.right);

		return root;
	}
	
	//BT template
    public Node connect2(Node root) {
        if(root == null) {
            return null;
        }
        
        helper(root.left, root.right);
        
        return root;
    }
    
    //BT template
    private void helper(Node node1, Node node2) {
        if(node1 == null || node2 == null) {
            return;
        }
        
        //pre-order
        node1.next = node2;
        
        //under same father
        helper(node1.left, node1.right);
        helper(node2.left, node2.right);
        
        //under diff father
        helper(node1.right, node2.left);
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

//		System.out.println(obj.connect(p1));
//		System.out.println(obj.connect2(p1));
		System.out.println(obj.connect2(p1));
		System.out.println(obj.connect4(p1));
	}
}
