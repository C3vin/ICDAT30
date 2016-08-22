package LeetCode;

public class n024_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
	       if(head == null) return null;
	        
	        ListNode fakehead = new ListNode(0);
	        fakehead.next = head;
	        
	        ListNode p = fakehead;
	        
	        while(p.next != null && p.next.next != null) {
	        	ListNode q = p.next;
	        	ListNode qq = p.next.next;
	        	
	        	p.next = qq;
	        	q.next = qq.next;
	        	qq.next = q;
	        	
	        	p = p.next.next;
	        }
	        
	        return fakehead.next;
	    
/*		if(head == null || head.next == null) {	// one element only
			//System.out.println("head:" +head);
			return head;
		}
		ListNode fakehead = new ListNode(0);
		fakehead.next = head;
		
		ListNode p1 = fakehead;
		ListNode p2 = head;

		if(p2 != null &&  p2.next != null) {
		    ListNode nextstart = p2.next.next;
		    p2.next.next = p1.next;		//p2.next.next = p2;
		    p1.next = p2.next;
		    p2.next = nextstart;
		    p1 = p2;
		    p2 = p1.next;
		} 
		return fakehead.next;*/
	}
	
	public static void main(String[] args) {
		n024_Swap_Nodes_in_Pairs obj = new n024_Swap_Nodes_in_Pairs();
		System.out.println(obj.swapPairs(ListNode.create(1234)));
	}
}
