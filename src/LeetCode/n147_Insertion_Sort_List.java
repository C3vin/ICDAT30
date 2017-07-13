package LeetCode;

//Sort a linked list using insertion sort.

public class n147_Insertion_Sort_List {
	public ListNode insertionSortList(ListNode head) {
		if(head == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		ListNode cur = head;
		
		while(cur != null) {
			
			pre = dummy;					//F: need to move every time, so we can make sure sorted. 
			ListNode next = cur.next;
			
			while(pre.next != null && pre.next.val <= cur.val)		//F: while loop!
				pre = pre.next;
			//SWAP
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		n147_Insertion_Sort_List obj = new n147_Insertion_Sort_List();
		ListNode head = ListNode.create(37495261);
		System.out.println(obj.insertionSortList(head));
	}
}
