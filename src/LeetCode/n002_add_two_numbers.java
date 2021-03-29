package LeetCode;

/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807. 
 */
public class n002_add_two_numbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	//Top Good
	public ListNode addTwoNumber3(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		ListNode p1 = l1; 
		ListNode p2 = l2;

		int sum = 0;

		while(p1 != null || p2 != null) {
			if(p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}
			if(p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}
			//System.out.println(sum);
			p.next = new ListNode(sum % 10);
			sum = sum / 10;
			p = p.next;
		}

		if(sum == 1) {
			p.next = new ListNode(1);		
		}

		return dummy.next;
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

		ListNode a1 = obj.new ListNode(2);
		ListNode a2 = obj.new ListNode(4);
		ListNode a3 = obj.new ListNode(3);

		ListNode b1 = obj.new ListNode(5);
		ListNode b2 = obj.new ListNode(6);
		ListNode b3 = obj.new ListNode(4);

		a1.next = a2;
		a2.next = a3;

		b1.next = b2;
		b2.next = b3;


		//System.out.println(obj.addTwoNumber(p1, q1));
		//System.out.println(obj.addTwoNumber2(p1, q1));		//result: 6556442551

		System.out.println(obj.addTwoNumber3(a1, b1));
	}
}
