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
	public static void main(String[] args) {
		n019_Remove_Nth_Node_From_End_of_List obj = new n019_Remove_Nth_Node_From_End_of_List();
		System.out.println(obj.removeNthFromEnd(ListNode.create(12345), 2));
		//System.out.print(ListNode.create(12345));
	}
} 