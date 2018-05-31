package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
  /** Initialize your data structure here. */
    HashMap<Integer,Integer> map = null;
    ArrayList<Integer> list = null;
    Random rng = new Random();

    public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if(!map.containsKey(val)){
        map.put(val,list.size());
        list.add(val);
        return true;
      }

      return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      Integer pos = map.get(val);
      if(pos == null){
        return false;
      }

      int numAtLastIndex = list.get(list.size()-1);
      list.set(pos, numAtLastIndex);
      map.put(numAtLastIndex, pos);

      map.remove(val);
      list.remove(list.size()-1);
      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return list.get(rng.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
    }
}
