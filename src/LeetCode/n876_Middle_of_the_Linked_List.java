package LeetCode;

import LeetCode.n083_Remove_Duplicates_from_Sorted_List.ListNode;

/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class n876_Middle_of_the_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode middleNode(ListNode head) {
		//slow - fast cycle
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println(slow.val);
		
		return slow;
	}
	
	public static void main(String[] args) {
		n876_Middle_of_the_Linked_List obj = new n876_Middle_of_the_Linked_List();
		ListNode p1 = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(4);
		ListNode p5 = obj.new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		System.out.println(obj.middleNode(p1));
	}
}
