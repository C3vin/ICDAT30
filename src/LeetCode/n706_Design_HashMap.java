package LeetCode;

import java.util.Arrays;

/*
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:
put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);         // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);         // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

/**
Note:
All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.
 */

public class n706_Design_HashMap {
	
	int[] table;
	
    /** Initialize your data structure here. */
    public n706_Design_HashMap() {
    	table = new int[1000000];
    	Arrays.fill(table, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        table[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return table[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        table[key] = -1;
    }
    
    /*
     * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
     */
    public static void main(String[] args) {
    	n706_Design_HashMap hashMap = new n706_Design_HashMap();
    	hashMap.put(1, 1);
    	hashMap.put(2, 2);         
    	System.out.println(hashMap.get(1));            // returns 1
    	System.out.println(hashMap.get(3));            // returns -1 (not found)
    	hashMap.put(2, 1);         // update the existing value
    	System.out.println(hashMap.get(2));            // returns 1 
    	hashMap.remove(2);         // remove the mapping for 2
    	System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}
