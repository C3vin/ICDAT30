package LeetCode;

public class n237_Delete_Node_in_a_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	/*
	 * [4,5,1',2] | [4,1,1',2] | [4,1,1',2] |       [4,1,2]   node = 5  
          ^           ^             |____|
         node       node      node.next linked       1' lost linked
         
	 */
	
	public void deleteNode(ListNode node) {
		if(node == null) {
			return;
		}
		
		node.val = node.next.val;			//update node val
		node.next = node.next.next;			//update next node
	}
	
	//Good red: https://leetcode.com/problems/delete-node-in-a-linked-list/discuss/461683/java-100-both-or-Solution-Explained
	public void deleteNode2(ListNode node) {
		while (true) {
			node.val = node.next.val;
			if (node.next.next == null) {
				node.next = null;
				return;
			}
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		n237_Delete_Node_in_a_Linked_List obj = new n237_Delete_Node_in_a_Linked_List();
		ListNode p1 = obj.new ListNode(4);
		ListNode p2 = obj.new ListNode(5);
		ListNode p3 = obj.new ListNode(1);
		ListNode p4 = obj.new ListNode(2);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		obj.deleteNode(p1);
	}
}
