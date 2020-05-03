package leet.apr30day;

import java.util.LinkedHashMap;

public class LRUCache {
  private final LinkedHashMap<Integer, Integer> map;
  private final int capacity;

  public LRUCache(int capacity) {
    this.map = new LinkedHashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    Integer res = this.map.get(key);
    if (res != null) {
      this.map.remove(key);
      this.map.put(key, res);
    }

    return res == null ? -1 : res;
  }

  public void put(int key, int value) {
    int val = this.get(key);
    if (val == -1) {
      if (this.map.size() == capacity) {
        this.map.remove(this.map.keySet().iterator().next());
      }
    }
    this.map.put(key, value);
  }
}

/**
 * ["LRUCache","get","put","get","put","put","get","get"]
 * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 */
