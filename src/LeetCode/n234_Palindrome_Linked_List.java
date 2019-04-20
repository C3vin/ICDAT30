package LeetCode;

public class n234_Palindrome_Linked_List {
/*	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}*/
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode secondHead = slow.next;
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
		slow.next = null;
		while(p1 != null && p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		secondHead.next = null;
		while(p1 != null) {
			if(head.val != p1.val) 
				return false;
			head = head.next;
			p1 = p1.next;
		}
		return true;
	}
	
	public boolean isPalindrome2(ListNode head) {
		
	}
	public static void main(String[] args) {
		n234_Palindrome_Linked_List obj = new n234_Palindrome_Linked_List();
		ListNode head = ListNode.create(12321);
		System.out.println(obj.isPalindrome(head));
		System.out.println(obj.isPalindrome2(head));
	}
}
