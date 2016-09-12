package LeetCode;

public class n141_Linked_List_Cycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode faster = head;
		while(faster != null && faster.next != null) {
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
