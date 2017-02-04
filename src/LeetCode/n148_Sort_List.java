package LeetCode;
//Sort a linked list in O(n log n) time using constant space complexity.
public class n148_Sort_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode faster = head;
		ListNode slow = head;
		while(faster.next != null && faster.next.next != null) {
			faster = faster.next.next;
			slow = slow.next;
		}
		ListNode secondHead = slow.next;
		slow.next = null;

		ListNode leftList = null; 
		ListNode rightList = null;
		
		if(head != secondHead) {
			leftList = sortList(head);
			rightList = sortList(secondHead);
		}
		
		return mergeTwoLists(leftList, rightList);
	}
	public ListNode mergeTwoLists(ListNode leftList, ListNode rightList) {
		/*if(rightList == null)
			return leftList;
		if(leftList == null) 
			return rightList;*/
		
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(leftList != null && rightList != null) {
			if(leftList.val < rightList.val){
				p.next = leftList;
				leftList = leftList.next;
			} else {
				p.next = rightList;
				rightList = rightList.next;
			}
			p = p.next;
		}
		if(leftList != null) {
			p.next = leftList;
		}
		if(rightList != null) {
			p.next = rightList;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		n148_Sort_List obj = new n148_Sort_List();
		ListNode head = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(11);
		ListNode p3 = obj.new ListNode(5);
		ListNode p4 = obj.new ListNode(3);
		ListNode p5 = obj.new ListNode(9);
		ListNode p6 = obj.new ListNode(7);
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		System.out.println(obj.sortList(head));
	}
}
