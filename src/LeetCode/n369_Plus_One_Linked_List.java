package LeetCode;

public class n369_Plus_One_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode plusOne(ListNode head) {
		ListNode h2 = reverse(head);
		
		ListNode pp = h2;
		while(pp != null) {
			if(pp.val < 9) {
				pp.val = pp.val + 1;
				break;
			} else {
				pp.val = 0;
				if(pp.next == null) {
					pp.next = new ListNode(1);		//9->9->9
					break;
				}
				pp = pp.next;
			}
		}
		return reverse(h2);
	}
	private ListNode reverse(ListNode head) {
		if(head == null) return head;
		ListNode p1 = head;
		ListNode p2 = p1.next;
		
		while(p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			//p1.next = null;	//F: can't do this!!! 
			p1 = p2;		//update
			p2 = tmp;
		}
		head.next = null;
		return p1;
	}
	public static void main(String[] args) {
		n369_Plus_One_Linked_List obj = new n369_Plus_One_Linked_List();
		ListNode head = obj.new ListNode(9);
		ListNode p2 = obj.new ListNode(9);
		ListNode p3 = obj.new ListNode(9);
		head.next = p2;
		p2.next = p3;
		System.out.println(obj.plusOne(head));
	}
}
