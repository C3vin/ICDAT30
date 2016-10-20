package LeetCode;

import java.util.Iterator;

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
