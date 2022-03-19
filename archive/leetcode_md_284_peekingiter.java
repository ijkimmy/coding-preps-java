import java.util.Iterator;
public class leetcode_md_284_peekingiter implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next;

    // 24m
    public leetcode_md_284_peekingiter(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        next = iter.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
    }
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer retval = next;
        next = iter.hasNext() ? iter.next() : null;
        return retval;
	}
	
	@Override
	public boolean hasNext() {
	    return next!=null || iter.hasNext();
	}
}
