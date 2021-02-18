package LeetCode;


/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class n203_Remove_Linked_List_Elements {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {};
		ListNode(int v) {
			val = v;
		}
		ListNode(int v, ListNode n) {
			val = v;
			next = n;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return head;
		}

		ListNode tmp = new ListNode(0);
		tmp.next = head;
		ListNode p = tmp;
		
		while(p.next != null) {
			if(p.next.val == val) {
				p.next = p.next.next;
			} else {
				p = p.next; 	//go next to find the remove value
			}
		}
		
		return tmp;
	}

	public static void main(String[] args) {
		n203_Remove_Linked_List_Elements obj = new n203_Remove_Linked_List_Elements();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(4);
		ListNode t5 = new ListNode(5);
		ListNode t6 = new ListNode(6);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;
		t5.next = t6;
		System.out.println(obj.removeElements(t1, 6));
	}
}
