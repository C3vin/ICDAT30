package LeetCode;

public class n002_add_two_numbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
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
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode newHead = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = newHead;
		int carry = 0;

		while(p1 != null || p2 != null) {
			//handle both not null
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
			if(p1 != null) {
				carry = carry + p1.val;
				p3.next = new ListNode(carry%10);
				carry = carry / 10;
				p3 = p3.next;						//F: don't forget move p3 & p1 to next node
				p1 = p1.next;

			} else if(p2 != null) {
				carry = carry + p2.val;
				p3.next = new ListNode(carry%10);
				carry = carry / 10;
				p3 = p3.next;
				p2 = p2.next;
			}
		}
		//need this to handle last one
		if(carry == 1) {
			p3.next = new ListNode(1);
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		n002_add_two_numbers obj = new n002_add_two_numbers();
		ListNode p1 = obj.new ListNode(0);
		ListNode p2 = obj.new ListNode(8);
		ListNode p3 = obj.new ListNode(6);
		ListNode p4 = obj.new ListNode(5);
		ListNode p5 = obj.new ListNode(6);
		ListNode p6 = obj.new ListNode(8);
		ListNode p7 = obj.new ListNode(3);
		ListNode p8 = obj.new ListNode(5);
		ListNode p9 = obj.new ListNode(7);
		
		ListNode q1 = obj.new ListNode(6);
		ListNode q2 = obj.new ListNode(7);
		ListNode q3 = obj.new ListNode(8);
		ListNode q4 = obj.new ListNode(0);
		ListNode q5 = obj.new ListNode(8);
		ListNode q6 = obj.new ListNode(5);
		ListNode q7 = obj.new ListNode(8);
		ListNode q8 = obj.new ListNode(9);
		ListNode q9 = obj.new ListNode(7);
		
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		p7.next = p8;
		p8.next = p9;
		
		q1.next = q2;
		q2.next = q3;
		q3.next = q4;
		q4.next = q5;
		q5.next = q6;
		q6.next = q7;
		q7.next = q8;
		q8.next = q9;
		
		//System.out.println(obj.addTwoNumber(p1, q1));
		System.out.println(obj.addTwoNumber2(p1, q1));		//result: 6556442551
	}
}
