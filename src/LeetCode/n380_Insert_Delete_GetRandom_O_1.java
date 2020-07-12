package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements (it's guaranteed that at least one element exists when this method is called). 
Each element must have the same probability of being returned.
 

Example:
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
public class n380_Insert_Delete_GetRandom_O_1 {
	HashMap<Integer, Integer> map;	
	List<Integer> list;
	Random rand = new Random();
	
    /** Initialize your data structure here. */
    public n380_Insert_Delete_GetRandom_O_1() {
        map = new HashMap<Integer, Integer>();				//<val for insert/remove, index for ArrayList>
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(list.size(), val);     //need to add by index
            
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val)) {
    		return false;
    	} else {
    		int index = map.get(val);					//get the ArrayList index
    		list.set(index, list.get(list.size()-1));	//set the last ArrayList element to the val index which will be remove ps: actually already remove val
    		map.put(list.get(list.size()-1), index);
    		
    		//remove
    		list.remove(list.size()-1);
    		map.remove(val);
    		
    		return true;
    	}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
