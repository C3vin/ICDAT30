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
		if(head==null||head.next==null) {
			return head;
		}

		ListNode p = null;		//Must null can't do new ListNode(0)

		//Null 1->2->3         Null<-1->2->3
		//  p  h  tmp                p  h  tmp
		while(head != null) {
			ListNode tmp = head.next;
			head.next = p;	
			//reset
			p = head;			//not p = p.next cuz NO next NOW
			head = tmp;
		}
		return p;				//p not head
	}

	//sol 2
	public ListNode reverseList3(ListNode head) {
		// case1: empty list or one element
		if(head == null || head.next == null) {
			return head;
		}

		// case: reverse from the rest after head
		ListNode newHead = reverseList3(head.next);
		// reverse between head and head->next
		head.next.next = head;				//e.g. 2->3,  2.next = 3, so 3.next -> 2 
											//            h    	                   h, reverse! 
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
