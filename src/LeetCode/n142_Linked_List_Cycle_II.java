package LeetCode;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Note: Do not modify the linked list.
Follow up:
Can you solve it without using extra space?*/

public class n142_Linked_List_Cycle_II {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head; 

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) {				//need to check after find the cycle
				slow = head;				//reset to head so no need another pointer
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				//System.out.println(slow.val);
				return slow;
			}
		}

		return null;
	}
	public static void main(String[] args) {
		n142_Linked_List_Cycle_II obj = new n142_Linked_List_Cycle_II();
		//ListNode head = ListNode.create();
		//head.next.next.next = head;
		ListNode p1 = obj.new ListNode(3);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(0);
		ListNode p4 = obj.new ListNode(-4);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p2;
		
		System.out.println(obj.detectCycle(p1));		//can't run
	}
}
