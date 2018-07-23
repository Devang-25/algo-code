package leetcode.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
    Iterator<Integer> iter1 = null,iter2 = null, curr = null;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iter1 = v1.iterator();
        iter2 = v2.iterator();
        curr = iter1;
        setNextValidIterator();
    }

    private void setNextValidIterator(){
        if(!curr.hasNext()){
            curr = (curr == iter1)?iter2:iter1;
        }
    }
    public int next() {
        int val = curr.next();
        curr = (curr == iter1)?iter2:iter1;
        setNextValidIterator();
        return val;
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }

    public static void main(String[] args) {
        ZigzagIterator zi = new ZigzagIterator(Arrays.asList(1,2),Arrays.asList(3,4,5,6));
        while(zi.hasNext()){
            System.out.println(zi.next());
        }

        new ZigzagIterator(Arrays.asList(1),Arrays.asList());
        while(zi.hasNext()){
            System.out.println(zi.next());
        }
    }
}
