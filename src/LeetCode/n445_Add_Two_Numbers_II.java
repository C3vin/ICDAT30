package LeetCode;

//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
public class n445_Add_Two_Numbers_II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) return null;
		l1 = reverse(l1);
		l2 = reverse(l2);
		
		return reverse(addTwoList(l1, l2));
	}
	public ListNode addTwoList(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) return null;
		
		ListNode dummy = new ListNode(0);	
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = dummy;
		int carry = 0;
		
		//case 1: same amount
		while(p1 != null && p2 != null) {
			int sum = carry + p1.val + p2.val;
			carry = sum/10;
			p3.next = new ListNode(sum%10);
			p3 = p3.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		//case 2: l1 rest
		while(p1 != null) {
			int sum = carry + p1.val;
			carry = sum/10;
			p3.next = new ListNode(sum%10);	//sum not carry
			p3 = p3.next;
			p1 = p1.next;
		}
		//case 3: l2 rest
		while(p2 != null) {
			int sum = carry + p2.val;
			carry = sum/10;
			p3.next = new ListNode(sum%10);
			p3 = p3.next;
			p2 = p2.next;
		}
		//case 4: last one
		if(carry == 1) {
			p3.next = new ListNode(1);
		}
		return dummy.next;
	}
	public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = null;	//why null, cuz pre node will point to p
		while(head != null) {
			ListNode tmp = head.next;
			head.next = p;
			p = head;
			head = tmp;
		}
		return p;
	}
	public static void main(String[] args) {
		n445_Add_Two_Numbers_II obj = new n445_Add_Two_Numbers_II();
		ListNode l1 = obj.new ListNode(3);
		ListNode p2 = obj.new ListNode(4);
		ListNode p3 = obj.new ListNode(2);
		ListNode p4 = obj.new ListNode(7);
		l1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		ListNode l2 = obj.new ListNode(5);
		ListNode p5 = obj.new ListNode(6);
		ListNode p6 = obj.new ListNode(4);
		l2.next = p5;
		p5.next = p6;
		
		System.out.println(obj.addTwoNumbers(l1, l2));
	}
}
