package LeetCode;

public class n021_Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				
				l1 = l1.next;
				p = p.next;
			} else {
				p.next = l2;
				
				l2 = l2.next;
				p = p.next;
			}
			
			//p = p.next;			//Need to move p after all, OR move to each if
		}
		//extra node
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		n021_Merge_Two_Sorted_Lists obj = new n021_Merge_Two_Sorted_Lists();
		System.out.println(obj.mergeTwoLists(ListNode.create(1357), ListNode.create(246)));
	}
}
