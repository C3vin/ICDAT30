package LeetCode;
//Amazon, Apple, FB
public class n206_Reverse_Linked_List {
	//Iterative 0ms
	public ListNode reverseList(ListNode head) {
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
	
	//Recursive	1ms
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) return head;		// || not &&
		
		ListNode newhead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		
		return newhead;
	}
	public static void main(String[] args) {
		n206_Reverse_Linked_List obj = new n206_Reverse_Linked_List();
		//System.out.print(obj.reverseList(ListNode.create(123)));
		System.out.print(obj.reverseList2(ListNode.create(123)));
	}
}
