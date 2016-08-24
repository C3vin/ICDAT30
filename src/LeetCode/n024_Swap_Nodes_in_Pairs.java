package LeetCode;

public class n024_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
	      if(head == null || head.next == null)
	        return head;
	    
	      ListNode fakehead = new ListNode(-1);
	      fakehead.next = head;
	      
	      ListNode ptr1 = fakehead;
	      ListNode ptr2 = head;
	      
	      while(ptr2!=null && ptr2.next!=null){
	          ListNode nextstart = ptr2.next.next;
	          ptr2.next.next = ptr2;	//2->1
	          ptr1.next = ptr2.next;	//0->2
	          ptr2.next = nextstart;	//1->3
	          
	          ptr1 = ptr2;
	          ptr2 = ptr2.next;
	      }
	    return fakehead.next;
	  }
	public static void main(String[] args) {
		n024_Swap_Nodes_in_Pairs obj = new n024_Swap_Nodes_in_Pairs();
		System.out.println(obj.swapPairs(ListNode.create(1234)));
	}
}

