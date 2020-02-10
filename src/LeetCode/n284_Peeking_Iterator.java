package LeetCode;

import java.util.Iterator;

/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation 
-- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class n284_Peeking_Iterator implements Iterator<Integer> {

	private Iterator<Integer> it;
	private boolean peekflag = false;
	private Integer nextElement = null;

	public n284_Peeking_Iterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.it = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(!peekflag) {
			nextElement = it.next();
			peekflag = true;
		}
		return nextElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(!peekflag) {
			return it.next();
		}
		peekflag = false;
		Integer result = nextElement;
		nextElement = null;
		return result;
	}

	@Override
	public boolean hasNext() {
		return peekflag || it.hasNext();
	}
}
