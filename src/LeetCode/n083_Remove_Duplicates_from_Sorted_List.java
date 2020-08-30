package LeetCode;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
 */
public class n083_Remove_Duplicates_from_Sorted_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		// one tmp sol
		if(head == null || head.next == null) {
			return head;
		}

		ListNode p = head;
		
		while(p!=null && p.next!=null) {		//while!
			if(p.val == p.next.val) {
				p.next = p.next.next;
				//p = p.next;         //F: No need, cuz need to compare with the rest!!!
			} else {
				p = p.next;
			}
		}
		
		System.out.println(head.val + " -> " + head.next.val + " -> " + head.next.next.val);
		
		return head;
	}

	public static void main(String[] args) {
		n083_Remove_Duplicates_from_Sorted_List obj = new n083_Remove_Duplicates_from_Sorted_List();
		ListNode p1 = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(1);
		ListNode p3 = obj.new ListNode(2);
		ListNode p4 = obj.new ListNode(3);
		ListNode p5 = obj.new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		System.out.println(obj.deleteDuplicates(p1));
	}
}