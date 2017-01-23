package LeetCode;

//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
public class n86_Partition_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null) return head;
		
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode small = dummy1;
		ListNode big = dummy2;
		
		while(head != null) {
			if(head.val < x) {
				small.next = head;
				small = small.next;
			} else {		//to handle x=0
				big.next = head;
				big = big.next;
			}
			head = head.next;
		}
		big.next = null;
		small.next = dummy2.next;
		
		return dummy1.next;
	}
	public static void main(String[] args) {
		n86_Partition_List obj = new n86_Partition_List();
		ListNode head = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(4);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(2);
		ListNode p5 = obj.new ListNode(5);
		ListNode p6 = obj.new ListNode(2);
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		System.out.println(obj.partition(head, 3));
	}
}
