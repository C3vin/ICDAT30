package LeetCode;


public class n148_Sort_List {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}

	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

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

	//this mergeTwoLists is LC 21 sol
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;

		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;                 //Need to move p after all
		}

		//extra nodes
		if(l1 != null) {
			p.next = l1;
		} 

		if(l2 != null) {
			p.next = l2;
		}

		return dummy.next;
	}
	//	public ListNode mergeTwoLists(ListNode leftList, ListNode rightList) {
	//		ListNode dummy = new ListNode(0);
	//		ListNode p = dummy;
	//		while(leftList != null && rightList != null) {
	//			if(leftList.val < rightList.val){
	//				p.next = leftList;
	//				leftList = leftList.next;
	//			} else {
	//				p.next = rightList;
	//				rightList = rightList.next;
	//			}
	//			p = p.next;
	//		}
	//		if(leftList != null) {
	//			p.next = leftList;
	//		}
	//		if(rightList != null) {
	//			p.next = rightList;
	//		}
	//		return dummy.next;
	//	}

	public static void main(String[] args) {
		n148_Sort_List obj = new n148_Sort_List();
		ListNode t1 = new ListNode(4);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(1);
		ListNode t4 = new ListNode(3);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		System.out.println(obj.sortList(t1));
	}
}
