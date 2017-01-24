package LeetCode;

public class n002_add_two_numbers {
	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;		//don't forget != null
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
	public ListNode addTwoNumber2(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = newHead;
		int carry = 0;
		
		while(p1 != null && p2 != null) {
			if(p1 != null) {
				carry = carry + p1.val;
				p1 = p1.next;
			}
			if(p2 != null) {
				carry = carry + p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(carry%10);
			carry = carry / 10;
			p3 = p3.next;
		}
		//need this to handle last one
		if(carry == 1) {
			p3.next = new ListNode(1);
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		n002_add_two_numbers obj = new n002_add_two_numbers();
		ListNode l1 = ListNode.create(245);
		ListNode l2 = ListNode.create(564);
		//System.out.println(obj.addTwoNumber(l1, l2));
		System.out.println(obj.addTwoNumber2(l1, l2));
	}
}
