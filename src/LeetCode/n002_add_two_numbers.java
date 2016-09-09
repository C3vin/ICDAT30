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

	public static void main(String[] args) {
		n002_add_two_numbers obj = new n002_add_two_numbers();
		ListNode l1 = ListNode.create(243);
		ListNode l2 = ListNode.create(564);
		System.out.println(obj.addTwoNumber(l1, l2));
	}
}
