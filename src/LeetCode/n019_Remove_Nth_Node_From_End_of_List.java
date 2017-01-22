package LeetCode;

public class n019_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n == 0) return head;
		if(head == null) return null;

		ListNode p = head;
		while(n>0 && p != null) {
			p = p.next;
			n--;
		}
		//n = list
		if(n>0) return head;

		if(p == null) return head.next;

		ListNode q = head;
		while(p.next != null) {
			q = q.next;
			p = p.next;
		}
		q.next = q.next.next;

		return head;
	}
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if(head == null || head.next == null) return null;

		ListNode faster = head;
		ListNode slow = head;
		for(int i=0; i<n; i++) {
			faster = faster.next;
		}
		// find nth node from begin
		if(faster == null){
			head = head.next;
			return head;
		}

		while(faster.next != null) {
			faster = faster.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;		//just need slow only, not need to use faster

		return head;
	}

	public static void main(String[] args) {
		n019_Remove_Nth_Node_From_End_of_List obj = new n019_Remove_Nth_Node_From_End_of_List();
		//System.out.println(obj.removeNthFromEnd(ListNode.create(12345), 2));
		System.out.println(obj.removeNthFromEnd2(ListNode.create(12), 2));
	}
} 