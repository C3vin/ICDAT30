package LeetCode;

public class n160_Intersection_of_Two_Linked_Lists {
	  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		  if(headA == null || headB == null) return null;
		  
		  ListNode p1 = headA;
		  ListNode p2 = headB;
		  
		  ListNode t1 = null;
		  ListNode t2 = null;
		  
		  while(true) {
			  if(p1 == null)
				  p1 = headB;
			  
			  if(p2 == null)
				  p2 = headA;
			  
			  if(p1.next == null)
				  t1 = p1;
			  
			  if(p2.next == null)
				  t2 = p2;
			  
			  if(t1 != null && t2 != null && t1 != t2)
				  return null;
			  
			  if(p1 == p2)
				  return p1;
			  
			  p1 = p1.next;
			  p2 = p2.next;
		  }
	  }
	  
	  public static void main(String[] args) {
		  n160_Intersection_of_Two_Linked_Lists obj = new n160_Intersection_of_Two_Linked_Lists();
		  ListNode headA = ListNode.create(12345);
		  ListNode headB = ListNode.create(87645);
		  headA.next.next.next.next = headB.next.next.next.next;
		  System.out.println(obj.getIntersectionNode(headA, headB));
	  }
}
