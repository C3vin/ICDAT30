package LeetCode;

public class n082_Remove_Duplicates_from_Sorted_List_II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode t = new ListNode(0);
		t.next = head;
		ListNode p = t;

		while(p.next!=null && p.next.next!=null) {
			int dup;
			if(p.next.val == p.next.next.val) {
				dup = p.next.val;
				while(p.next.val == dup && p.next != null) {	//F: !!! while loop !!!
					p.next = p.next.next;						//F: move and remove dup node, keep move to right(dup) until diff val, "remove p.next"
				}
				System.out.println(p.next.val);
			} else {
				p = p.next;
			}
		}
		System.out.println(t.val + " -> " + t.next.val + " -> " + t.next.next.val);
		return t.next;
	}
	public static void main(String[] args) {
		n082_Remove_Duplicates_from_Sorted_List_II obj = new n082_Remove_Duplicates_from_Sorted_List_II();
		ListNode p1 = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(1);
		ListNode p3 = obj.new ListNode(1);
		ListNode p4 = obj.new ListNode(2);
		ListNode p5 = obj.new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		System.out.println(obj.deleteDuplicates(p1));
	}
}
