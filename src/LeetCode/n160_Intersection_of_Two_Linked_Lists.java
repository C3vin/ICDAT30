package LeetCode;

public class n160_Intersection_of_Two_Linked_Lists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) {
	    	return null;
	    }
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different length, then we will stop the loop after second iteration
	    while(a != b) {
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = (a == null) ? headB : a.next;
	        b = (b == null) ? headA : b.next;    
	    }
	    
	    return a;
	    
//		if(headA == null || headB == null) 
//			return null;
//
//		ListNode p1 = headA;
//		ListNode p2 = headB;
//
//		ListNode t1 = null;
//		ListNode t2 = null;
//
//		while(true) {
//			if(p1 == null)
//				p1 = headB;
//
//			if(p2 == null)
//				p2 = headA;
//
//			if(p1.next == null)
//				t1 = p1;		//setup tail
//
//				if(p2.next == null)
//					t2 = p2;		//setup tail
//
//					//The two links have different tails. So just return null;
//				if(t1 != null && t2 != null && t1 != t2)	//why need t1 != null e.g.[3] ,[2,3], t1 = 3, no t2. so need to make sure t2 != null
//					return null;
//
//				if(p1 == p2)		//F: need to use p1 not t1
//					return p1;
//
//				p1 = p1.next;
//				p2 = p2.next;
//		}
	}
	
	//Cool, [LC141 - LC142]
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		// find last node of list A (c3)
		ListNode endA = headA;
		while (endA.next != null) {
			endA = endA.next;
		}
		// join c3 to b1 making a c1...c3-b1...b3-c1 loop (if b3 indeed points to c1)
		endA.next = headB;

		//ListNode start = null; // if there's no cycle this will stay null
		// Floyd's cycle finder  
		ListNode slow = headA;
		ListNode fast = headA;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) { // found a cycle
				// reset to beginning to find cycle start point (c1)
				//start = headA;			//only diff is use 'start' NodeList not 'slow' !!!
//				while (slow != start) {
//					slow = slow.next;
//					start = start.next;
//				}
//				break;
				
				slow = headA;
				
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				//unjoin c3-b1, diff than LC142, cuz 142 is single link, this is two Linked List
				endA.next = null;
				
				return slow;
			}
		}
		// unjoin c3-b1
		endA.next = null;
		
		return null;
		//return start;
	}
	
	public static void main(String[] args) {
		n160_Intersection_of_Two_Linked_Lists obj = new n160_Intersection_of_Two_Linked_Lists();
		ListNode a1 = obj.new ListNode(4);
		ListNode a2 = obj.new ListNode(1);
		ListNode a3 = obj.new ListNode(8);
		ListNode a4 = obj.new ListNode(4);
		ListNode a5 = obj.new ListNode(5);
		a1.next = a2;
		a1.next.next = a3;
		a1.next.next.next = a4;
		a1.next.next.next.next = a5;
		
		ListNode b1 = obj.new ListNode(5);
		ListNode b2 = obj.new ListNode(6);
		ListNode b3 = obj.new ListNode(1);
		ListNode b4 = obj.new ListNode(8);
		ListNode b5 = obj.new ListNode(4);
		ListNode b6 = obj.new ListNode(5);
		b1.next = b2;
		b1.next.next = b3;
		b1.next.next.next = b4;
		b1.next.next.next.next = b5;
		b1.next.next.next.next.next = b6;
		
		//this part is important for testing, need to let the code knows the intersection point.
		a1.next.next = b1.next.next.next; 
		
		System.out.println(obj.getIntersectionNode(a1, b1));
		System.out.println(obj.getIntersectionNode2(a1, b1));
	}
}
