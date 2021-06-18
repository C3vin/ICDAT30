package LeetCode;

public class n024_Swap_Nodes_in_Pairs {
	
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	//O(n) O(1)
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode p = dummy;
		
		while(head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;
			
			//swap
			p.next = second;
			first.next = second.next;
			second.next = first;
			
			//reset
			p = first;
			head = first.next;
		}
		
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		n024_Swap_Nodes_in_Pairs obj = new n024_Swap_Nodes_in_Pairs();
		
		ListNode p1 = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(4);
		
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		System.out.println(obj.swapPairs2(p1));
	}
}

