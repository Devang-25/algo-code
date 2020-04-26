package leetcode.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {
    private Integer next = null;
    private Iterator<Integer> iterator = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = iterator.hasNext()? iterator.next(): null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(next == null){
            throw new NoSuchElementException();
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer val = next;
        Integer temp = iterator.hasNext()? iterator.next():null;
        next = temp;
        if(val == null){
            throw new NoSuchElementException();
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return next != null ;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        PeekingIterator pi = new PeekingIterator(nums.iterator());
        while(pi.hasNext()){
            System.out.println(pi.next() + " -> " + pi.peek());
        }
    }
}
