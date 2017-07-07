package LeetCode;
@Alg(type="LinkedList", com="A,AA,F", level="easy", num=206)
public class n206_Reverse_Linked_List {
/*	//Iterative 0ms
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
	}*/
	//Iterative Good!
	public ListNode reverseList4(ListNode head) {
		if(head==null||head.next==null)
			return head;

		ListNode p = null;

		//Null 1->2->3         Null<-1->2->3
		//  p  h  tmp                p  h  tmp
		while(head != null) {
			ListNode tmp = head.next;
			head.next = p;	
			//reset
			p = head;
			head = tmp;
		}
		return p;
	}
	
	//Recursive	1ms
/*	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null) 		// || not &&
			return head;		

		//get second node    
		ListNode second = head.next;
		//set first's next to be null
		head.next = null;

		ListNode rest = reverseList2(second);
		second.next = head;

		return rest;
	}*/

	public ListNode reverseList3(ListNode head) {
		// case1: empty list
		if (head == null) 
			return head;
		// case2: only one element list
		if (head.next == null) 
			return head;

		// case3: reverse from the rest after head
		ListNode newHead = reverseList3(head.next);

		// reverse between head and head->next
		head.next.next = head;				//e.g. (head.next).next = head  2(head).next = 3, so 3.next -> 2 

		// unlink list from the rest
		head.next = null;					//e.g. 2.next will become null, so 2->3 old link will broken

		return newHead;
	}
	public static void main(String[] args) {
		n206_Reverse_Linked_List obj = new n206_Reverse_Linked_List();
		//System.out.print(obj.reverseList(ListNode.create(123)));
		//System.out.println(obj.reverseList2(ListNode.create(123)));
		System.out.println(obj.reverseList3(ListNode.create(123)));
		System.out.println(obj.reverseList4(ListNode.create(123)));
	}
}
