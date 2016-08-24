package LeetCode;

public class n025_Reverse_Nodes_in_kGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k == 1)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		ListNode pre = dummy;
		ListNode cur = head;
		
		while(cur != null){
			count ++;
			ListNode next = cur.next;
			if(count == k){
				System.out.println(pre.toString() + " : " + next.toString());
				pre = reverse(pre, next);
				count = 0;   
			}
			cur = next;
		}
		return dummy.next;
	}
	public static ListNode reverse(ListNode pre, ListNode next){
		ListNode last = pre.next;//where first will be doomed "last"
		ListNode cur = last.next;
		
		while(cur != next){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			
			cur = last.next;
		}
		return last;
	}
	public static void main(String[] args) {
		n025_Reverse_Nodes_in_kGroup obj = new n025_Reverse_Nodes_in_kGroup();
		System.out.println(obj.reverseKGroup(ListNode.create(12345), 3));
		System.out.println("orgi: "+ListNode.create(12345));
	}
}
