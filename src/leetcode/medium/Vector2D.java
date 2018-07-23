package leetcode.medium;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> listIterator=null;
    Iterator<Integer> iterator = null;
    public Vector2D(List<List<Integer>> vec2d) {
        listIterator = vec2d.iterator();
        if(listIterator.hasNext()){
            iterator = listIterator.next().iterator();
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if(iterator == null){
            return false;
        }

        if(!iterator.hasNext()) {
            while (listIterator.hasNext() && !iterator.hasNext()) {
                List<Integer> list = listIterator.next();
                iterator = list.iterator();

            }
        }
        return iterator.hasNext();
    }
}
