package LeetCode;

public class n142_Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
		
	}
	public static void main(String[] args) {
		n142_Linked_List_Cycle_II obj = new n142_Linked_List_Cycle_II();
		ListNode head = ListNode.create(123456);
		head.next.next.next = head;
		System.out.println(obj.detectCycle(head));
	}
}
