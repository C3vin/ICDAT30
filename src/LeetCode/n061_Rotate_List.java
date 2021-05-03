package LeetCode;

/*
Given the head of a linked list, rotate the list to the right by k places.
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
public class n061_Rotate_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        
        int len = 1;                //why 1, cuz p.next != null 
        ListNode p = head;
        while(p.next != null) {     //why p.next not p, cuz need to do p.next = head, if p is will return error
            p = p.next;
            len++;                  //get the ListNode length
        }
        
        k = k % len;                //mod
        
        if(k == 0) {
            return head;            //return original list
        }
        
        ListNode newTail = head; 
        for(int i=0; i < len-k-1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        p.next = head;              //need len start at 1
        
        return newHead;
	}
	
	public static void main(String[] args) {
		n061_Rotate_List obj = new n061_Rotate_List();
		
		ListNode head = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(4);
		ListNode p5 = obj.new ListNode(5);
		
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		
		System.out.println(obj.rotateRight(head, 2));
	}
}
