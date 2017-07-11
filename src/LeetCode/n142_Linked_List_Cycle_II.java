package LeetCode;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Note: Do not modify the linked list.
Follow up:
Can you solve it without using extra space?*/

public class n142_Linked_List_Cycle_II {
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
				return slow;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		n142_Linked_List_Cycle_II obj = new n142_Linked_List_Cycle_II();
		ListNode head = ListNode.create(12345);
		head.next.next.next = head;
		System.out.println(obj.detectCycle(head));		//can't run
	}
}
