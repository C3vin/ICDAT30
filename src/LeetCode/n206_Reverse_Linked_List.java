package LeetCode;
@Alg(type="LinkedList", com="A,AA,F", level="easy", num=206)
public class n206_Reverse_Linked_List {
	//Iterative 0ms
	public ListNode reverseList(ListNode head) {
		if(head==null||head.next==null)
			return head;

		ListNode p1 = head;
		ListNode p2 = p1.next;

		head.next = null;
		while(p1!=null && p2!=null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			//reset
			p1=p2;
			p2=tmp;
		}
		return p1;
	}

	//Recursive	1ms
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) return head;		// || not &&

		//get second node    
		ListNode second = head.next;
		//set first's next to be null
		head.next = null;

		ListNode rest = reverseList2(second);
		second.next = head;

		return rest;
	}

	//Recursive	
	public ListNode reverseList3(ListNode head) {
		// case1: empty list // case2: only one element list
		if(head == null || head.next == null) return head;
		// case3: reverse from the rest after head
		ListNode newHead = reverseList3(head.next);
		// reverse between head and head->next
		head.next.next = head;
		// unlink list from the rest
		head.next = null;

		return newHead;
	}
	public static void main(String[] args) {
		n206_Reverse_Linked_List obj = new n206_Reverse_Linked_List();
		//System.out.println(obj.reverseList(ListNode.create(123)));
		//System.out.println(obj.reverseList2(ListNode.create(123)));
		System.out.println(obj.reverseList3(ListNode.create(123)));
	}
}
