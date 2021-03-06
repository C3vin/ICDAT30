package LeetCode;

//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//return 1->4->3->2->5->NULL.
public class n092_Reverse_Linked_List_II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	//Good, [LC206 - LC92]
	public ListNode reverseBetween2(ListNode head, int left, int right) {
		//https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		for(int i=0; i<left-1; i++) {
			pre = pre.next;
		}
		
		ListNode rightNode = pre;
		for(int i=0; i<right-left+1; i++) {			//why can't just move to right, cuz start at 0, also handle [5] left=1, right=1
			rightNode = rightNode.next;
		}
		
		ListNode leftNode = pre.next;
		ListNode cur = rightNode.next;
		
		//cut
		pre.next = null;
		rightNode.next = null;
		
		reverse(leftNode);
		
		//build tree
		pre.next = rightNode;
		leftNode.next = cur;
		
		
		return dummy.next;
	}
	
	//LC206
	private void reverse(ListNode head) {
		ListNode p = null;
		
		while(head != null) {
			ListNode tmp = head.next;
			head.next = p;
			
			p = head;
			head = tmp;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode p = dummy;
		for(int i=0; i<m-1; i++) {
			p = p.next;						//before m
		}
		
		ListNode p1 = p.next;				//m
		ListNode secondtail = p1;
		ListNode secondhead = secondtail;
		p.next = null;						//F: avoid cycle
		
		for(int i=0; i<n-m; i++) {
			secondhead = secondhead.next;	//n
		}
		ListNode tail = secondhead.next;
		secondhead.next = null;				//F: avoid cycle
		
		//reverse, all the reverse Linked List are the same!
		ListNode p2 = p1.next;
		while(p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		
		p.next = secondhead;
		secondtail.next = tail;

		return dummy.next;
	}
	public static void main(String[] args) {
		n092_Reverse_Linked_List_II obj = new n092_Reverse_Linked_List_II();
		ListNode head = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(4);
		ListNode p5 = obj.new ListNode(5);
		
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		
		//System.out.println(obj.reverseBetween(head, 2, 4));
		
		System.out.println(obj.reverseBetween2(head, 2, 4));
	}
}
