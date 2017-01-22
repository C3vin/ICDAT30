package LeetCode;
//Given {1,2,3,4}, reorder it to {1,4,2,3}.
public class n143_Reorder_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode fastHead = head;
		while(fast != null && fast.next != null && fast.next.next != null) {	//because fast.next.next so fast still in the list
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//reverse
		ListNode p1 = slow.next;
		slow.next = null; 
		p1 = reverseNode(p1);
	/*	ListNode p1 = slow.next;
		ListNode p2 = p1.next;
		slow.next = null; 			//F: this is for out purpose
		while(p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}*/
		
		while(fastHead != null && p1 != null) {
			ListNode tmpFast = fastHead.next;
			ListNode tmpP1 = p1.next;
			fastHead.next = p1;
			p1.next = tmpFast;
			
			fastHead = tmpFast;
			p1 = tmpP1;
		}
	}
	public ListNode reverseNode(ListNode head) {
		   if(head==null||head.next==null)
	            return head;

	        ListNode p1 = head;
	        ListNode p2 = p1.next;

	        head.next = null;
	        while(p1!=null && p2!=null) {
	            ListNode tmp = p2.next;
	            p2.next = p1;
	            //reset
	            p1=p2;
	            p2=tmp;
	        }
	        return p1;
	}
	public static void main(String[] args) {
		n143_Reorder_List obj = new n143_Reorder_List();
		ListNode head = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(4);
		ListNode p5 = obj.new ListNode(5);
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		obj.reorderList(head);
	}
}
