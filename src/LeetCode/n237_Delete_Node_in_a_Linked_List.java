package LeetCode;

public class n237_Delete_Node_in_a_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public void deleteNode(ListNode node) {
		if(node == null) 
			return;
		node.val = node.next.val;			//update node val
		node.next = node.next.next;			//update next node
	}
	
	public static void main(String[] args) {
		n237_Delete_Node_in_a_Linked_List obj = new n237_Delete_Node_in_a_Linked_List();
		ListNode p1 = obj.new ListNode(1);
		ListNode p2 = obj.new ListNode(2);
		ListNode p3 = obj.new ListNode(3);
		ListNode p4 = obj.new ListNode(4);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
	}
}
