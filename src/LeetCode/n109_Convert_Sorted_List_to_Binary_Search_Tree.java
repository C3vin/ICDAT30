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
	//top-down
	private TreeNode toBST(ListNode head, ListNode tail) {
		if(head == tail) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.val);
		TreeNode root = new TreeNode(slow.val);		//find the mid by using fast-slow 
		root.left = toBST(head, slow);
		root.right = toBST(slow.next, tail);
		
		return root; 
	}
	
	public TreeNode sortedListToBST2(ListNode head) {
		int len = 0;
		ListNode p = head;
		while(p != null) {
			len++;
			p = p.next;
		}
		return toBST2(head, 0, len-1);
	}
	private TreeNode toBST2(ListNode head, int start, int end) {
		if(start == end) {
			return null;
		}
		int mid = (end - start)/2 + start;
		//int mid = (start + end) >>> 1;
		System.out.println(mid);
		TreeNode left = toBST2(head, start, mid);
		
		TreeNode parent = new TreeNode(head.val);
		parent.left = left;
		head = head.next;
		TreeNode right = toBST2(head, mid+1, end);
		parent.right = right;
		
		return parent;
	}
	
	ListNode cur = null;
	public TreeNode sortedListToBST3(ListNode head) {
		cur = head;
		int end = 0;
		while(head != null) {
			end++;
			head = head.next;
		}
		return toBST3(0, end);
	}
	private TreeNode toBST3(int start, int end) {
		if(start == end) {
			return null;
		}
		int mid = (end - start)/2 + start;
		//int mid = (start + end) >>> 1;
		System.out.println(mid);
		TreeNode left = toBST3(start, mid);
		
		TreeNode parent = new TreeNode(cur.val);
		parent.left = left;
		cur = cur.next;
		TreeNode right = toBST3(mid+1, end);
		parent.right = right;
		
		return parent;
	}
	//ref:https://leetcode.wang/leetcode-109-Convert-Sorted-List-to-Binary-Search-Tree.html
	//
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
		System.out.println(obj.sortedListToBST2(n1));
		System.out.println(obj.sortedListToBST3(n1));
	}
}
