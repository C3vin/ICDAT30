package LeetCode;

import LeetCode.n199_Binary_Tree_Right_Side_View.TreeNode;

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
of every node never differ by more than 1.

Example:
Given the sorted linked list: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
 */
public class n109_Convert_Sorted_List_to_Binary_Search_Tree {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		return toBST(head, null);
	}
	public TreeNode toBST(ListNode head, ListNode tail) {
		if(head == tail) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = toBST(head, slow);
		root.right = toBST(slow.next, tail);
		
		return root; 
	}
	public static void main(String[] args) {
		n109_Convert_Sorted_List_to_Binary_Search_Tree obj = new n109_Convert_Sorted_List_to_Binary_Search_Tree();
		ListNode n1 = obj.new ListNode(-10);
		ListNode n2 = obj.new ListNode(-3);
		ListNode n3 = obj.new ListNode(0);
		ListNode n4 = obj.new ListNode(5);
		ListNode n5 = obj.new ListNode(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(obj.sortedListToBST(n1));
	}
}
