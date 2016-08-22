package LeetCode;

public class n023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
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
	}

	public static void main(String[] args) {
    	n023_Merge_k_Sorted_Lists obj = new n023_Merge_k_Sorted_Lists();
    	ListNode[] test = new ListNode[6];
    	test[0] = ListNode.create(6);
    	test[1] = ListNode.create(5);
    	test[2] = ListNode.create(2);
    	test[3] = ListNode.create(4);
    	test[4] = ListNode.create(3);
    	test[5] = ListNode.create(1);
    	System.out.println(obj.mergeKLists(test));
    }
	
}
