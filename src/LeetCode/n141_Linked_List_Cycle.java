package LeetCode;

public class n141_Linked_List_Cycle {
	/**
	 *  if slow and faster meet, return true (even need to take a long time)  
	 */
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode faster = head;
		while(faster != null && faster.next != null) {		//check faster and faster.next
			slow = slow.next;
			faster = faster.next.next;
			if(slow == faster) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n141_Linked_List_Cycle obj = new n141_Linked_List_Cycle();
		ListNode head = ListNode.create(123456);
		head.next.next.next = head;
		System.out.println(obj.hasCycle(head));
	}
}
