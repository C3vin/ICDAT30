package LeetCode;

import java.util.Arrays;

/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
 */
public class n705_Design_HashSet {
	int[] set;
	/** Initialize your data structure here. */
    public n705_Design_HashSet() {
        set = new int[1000000];
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        set[key] = 1;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(set[key] == -1) {
        	return false;
        } else 
        	return true;
    }
    
    /*
    /**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
     */
    public static void main(String[] args) {
    	n705_Design_HashSet hashSet = new n705_Design_HashSet();
    	hashSet.add(1);         
    	hashSet.add(2);         
    	System.out.println(hashSet.contains(1));    // returns true
    	System.out.println(hashSet.contains(3));    // returns false (not found)
    	hashSet.add(2);          
    	System.out.println(hashSet.contains(2));    // returns true
    	hashSet.remove(2);          
    	System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
