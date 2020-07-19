package LeetCode;

import java.util.PriorityQueue;

public class n023_Merge_k_Sorted_Lists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	/*    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergerHelper(lists, 0, lists.length-1);
    }

    private ListNode mergerHelper(ListNode[] lists, int L, int R) {
    	if(L == R) {
    		System.out.println("L: " +L + " R: " +R);
    		return lists[L];		//??
    	}
    	int m = L + (R-L)/2; 
    	System.out.println("m: "+m);

    	ListNode left = mergerHelper(lists, L, m);
    	System.out.println("left: "+left.toString());
    	ListNode right = mergerHelper(lists, m+1, R);
    	System.out.println("right:"+right.toString());
		return n021_Merge_Two_Sorted_Lists.mergeTwoLists(left, right);
	}*/
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> {
			return a.val - b.val;									// {} with return
		});

		ListNode head = new ListNode(0);
		ListNode cur = head;

		for(ListNode list : lists) {
			if(list != null) {
				queue.offer(list);
			}
		}

		while(!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;

			if(cur.next != null) {				//handle last element
				queue.offer(cur.next);			//need to add back the rest of the elements 
			}
		}

		return head.next;
	}
	public static void main(String[] args) {
		n023_Merge_k_Sorted_Lists obj = new n023_Merge_k_Sorted_Lists();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(4);
		ListNode t3 = new ListNode(5);
		ListNode t4 = new ListNode(1);
		ListNode t5 = new ListNode(3);
		ListNode t6 = new ListNode(4);
		ListNode t7 = new ListNode(2);
		ListNode t8 = new ListNode(6);
		t1.next = t2;
		t2.next = t3;
		t4.next = t5;
		t5.next = t6;
		t7.next = t8;
		ListNode[] ListNodes = new ListNode[] {t1,t4,t7};
		System.out.println(obj.mergeKLists(ListNodes));
	}
}
