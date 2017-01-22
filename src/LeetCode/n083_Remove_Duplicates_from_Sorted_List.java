package LeetCode;

public class n083_Remove_Duplicates_from_Sorted_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode deleteDuplicates(ListNode head) {
		// one tmp sol
		if(head == null || head.next == null) return head;
		
		ListNode p = head;
		while(p!=null && p.next!=null) {
			if(p.val == p.next.val) {
				p.next = p.next.next;
				//p = p.next;         //F: No need, cuz need to compare with the rest!!!
			} else {
				p = p.next;
			}
		}
		System.out.println(head.val + " -> " + head.next.val + " -> " + head.next.next.val);
		return head;
		
		// two tmp sol
/*		if(head == null || head.next == null) return head;  //F: not null, is head
		
		ListNode pre = head;
		ListNode p = head.next;
		
		while(p != null) {				//F: OMG is while! F: p not p.next
			if(p.val == pre.val) {
				pre.next = p.next;
				//reset, F: no pre, cuz need to compare with the rest
				p = p.next;
			} else {
				pre = p;
				p = p.next;
			}
		}
		System.out.println(head.val + " -> " + head.next.val + " -> " + head.next.next.val);
		return head;*/
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