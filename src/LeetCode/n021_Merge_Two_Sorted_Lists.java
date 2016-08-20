package LeetCode;

public class n021_Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode p = h;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}

		return h.next;
	}
	public static void main(String[] args) {
		n021_Merge_Two_Sorted_Lists obj = new n021_Merge_Two_Sorted_Lists();
		System.out.println(obj.mergeTwoLists(ListNode.create(135), ListNode.create(246)));
		System.out.print(ListNode.create(135));
	}
}
