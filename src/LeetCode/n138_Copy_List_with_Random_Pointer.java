package LeetCode;

import java.util.HashMap;

public class n138_Copy_List_with_Random_Pointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	//hashmap
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) 
			return head;
		
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newhead = new RandomListNode(head.label);
		map.put(head, newhead);
		
		RandomListNode oldp = head.next;
		RandomListNode newp = newhead;
		
		while(oldp!= null) {
			RandomListNode newNode = new RandomListNode(oldp.label);
			map.put(oldp, newNode);
			newp.next = newNode;		//F: Link together, need to use pointer!
			
			oldp = oldp.next;
			newp = newp.next;			//F: don't forget 
		}
		//reset
		oldp = head;
		newp = newhead;
		//config random nodes
		while(oldp != null) {
			newp.random = map.get(oldp.random);
			oldp = oldp.next;
			newp = newp.next;
		}
		return newhead;
	}
	
	public RandomListNode copyRandomList2(RandomListNode head) {
		if(head == null) 
			return head;
		
		RandomListNode p = head;
		RandomListNode newhead = null;
		
		while(p != null) {
			RandomListNode newNode = new RandomListNode(p.label);
			newNode.next = p.next;
			p.next = newNode;		//oldp next -> newNdoe
			p = newNode.next;		//move p to next (newNode next)
		}
		//reset
		p = head;
		//config random nodes
		while(p != null) {
			if(p.random != null)				//F: need to check, because some node don't have random node 
				p.next.random = p.random.next;
			
			p = p.next.next;
		}
		//reset 
		p = head;
		newhead = head.next;
		//separate two Linked List
		while(p != null) {
			RandomListNode newNode = p.next;
			p.next = newNode.next;
			if(newNode.next != null)
				newNode.next = p.next.next;
			p = p.next;
		}
		return newhead;
	}
	public static void main(String[] args) {			
		n138_Copy_List_with_Random_Pointer obj = new n138_Copy_List_with_Random_Pointer();
		RandomListNode head = obj.new RandomListNode(1);
		RandomListNode p3 = obj.new RandomListNode(2);
		RandomListNode p5 = obj.new RandomListNode(3);
		RandomListNode p2 = obj.new RandomListNode(4);
		RandomListNode p4 = obj.new RandomListNode(5);
		RandomListNode p6 = obj.new RandomListNode(6);
		head.next = p3;
		p3.next = p5;
		p5.next = p2;
		p2.next = p4;
		p4.next = p6;
		p2.random = p3;
		p3.random = p4;
		System.out.println(obj.copyRandomList(head));
		System.out.println(obj.copyRandomList2(head));
	}
}
