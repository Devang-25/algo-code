package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by mns on 5/29/18.
 */
public class RandomizedCollection {
    /** Initialize your data structure here. */
    HashMap<Integer,HashSet<Integer>> map = null;
    ArrayList<Integer> list = null;
    Random rng = new Random();

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        HashSet<Integer> positions = map.get(val);
        if(positions == null){
            positions = new HashSet<>();
            map.put(val,positions);
        }

        positions.add(list.size());
        list.add(val);

        if(positions.size() == 1){
            return true;
        }

        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        HashSet<Integer> positions = map.get(val);
        if(positions == null || positions.size() == 0){
            return false;
        }

        int lastNumber = list.get(list.size()-1);
        if(val == lastNumber){  // same as val == lastNumber
            positions.remove(list.size()-1);
        }else{
            int deletePosition = positions.iterator().next();
            HashSet<Integer> lastNumberPositions = map.get(lastNumber);

            lastNumberPositions.remove(list.size()-1);
            lastNumberPositions.add(deletePosition);
            list.set(deletePosition,lastNumber);

            positions.remove(deletePosition);

        }

        list.remove(list.size()-1);
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rng.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(4);
        rc.insert(3);
        rc.insert(4);
        rc.insert(2);
        rc.insert(4);
        rc.remove(4);
        rc.remove(3);
        rc.remove(4);
        rc.remove(4);
    }
}
