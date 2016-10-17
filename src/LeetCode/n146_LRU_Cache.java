package LeetCode;

import java.util.HashMap;

public class n146_LRU_Cache {
	class Node {
		int key;
		int value;
		Node pre;
		Node next;
		public Node(int k, int v) {
			key = k;
			value = v;
		}
	}
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public n146_LRU_Cache(int capacity) {		//constructor
		this.capacity = capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}
	private void remove(Node n) {
		if(n.pre!=null) {			//?
			n.pre.next = n.next;
		} else {
			head = n.next;
		}
		if(n.next!=null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}
	}
	private void setHead(Node n) {
		n.next = head;
		n.pre = null;
		if(head!=null)
			head.pre = n;

		head=n;		//?
		if(end==null)
			end = head;
	}
	public void set(int key, int value) {
		if(map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if(map.size() >= capacity) { 		//remove the end, then put into head
				map.remove(end.key); //can we do end.value
				remove(end);
				setHead(created);
			} else {
				setHead(created);
			}
			map.put(key, created);	
		}
	}
}
