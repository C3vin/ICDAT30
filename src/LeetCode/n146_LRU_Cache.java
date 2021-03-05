package LeetCode;

import java.util.HashMap;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 /capacity/ );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

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

	private int capacity;
	private HashMap<Integer, Node> map;
	private Node head;
	private Node tail;

	public n146_LRU_Cache(int capacity) {		//constructor
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = null;
		tail = null;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);						//Don't forget!!!
			setHead(node);

			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;			//F: need to assign new value!!! update the value
			
			remove(old);				//Don't forget!!!
			setHead(old);
		} else {
			Node created = new Node(key, value);
			
			if(map.size() >= capacity) { 	//map.size, >= !!!!!!
				map.remove(tail.key);  		//map.remove
				remove(tail); 				//remove (Node)
//			} else {
//				setHead(created);
			}
			setHead(created);
			map.put(key, created);			//don't forget to add it!	
		}
	}

	private void remove(Node node) {
		if(node.pre != null) {			 
			node.pre.next = node.next;
		} else {
			head = node.next;	 		//F: means n is head
		}

		if(node.next != null) {
			node.next.pre = node.pre;
		} else {
			tail = node.pre;
		}
	}
	
	private void setHead(Node node) {
		if(head != null) {				//1. check head != null or not
			head.pre = node;
		}

		node.next = head;				//2. setup node pre and next
		node.pre = null;
		head = node;		 			//3. assign head to node

		if(tail == null) {				//4. check if tail is null
			tail = head;				//F: must have this do deal with first time add
		}
	}
	
	public static void main(String[] args) {
		/*		n146_LRU_Cache obj = new n146_LRU_Cache(2);
		obj.set(1, 23);
		obj.set(2, 33);
		obj.set(3, 56);
		System.out.println(obj.get(2));
		obj.set(4, 99);
		System.out.println(obj.get(4));*/
		n146_LRU_Cache obj = new n146_LRU_Cache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));       // returns 1
		obj.put(3, 3);    // evicts key 2
		System.out.println(obj.get(2));       // returns -1 (not found)
		obj.put(4, 4);    // evicts key 1
		System.out.println(obj.get(1));       // returns -1 (not found)
		System.out.println(obj.get(3));       // returns 3
		System.out.println(obj.get(4));       // returns 4
	}
}
