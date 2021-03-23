package datastructures;

import java.util.LinkedHashMap;

public class LRUCache {
  private int capacity;
  private LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new LinkedHashMap<>();
  }

  public int get(int key) {
    int value = cache.getOrDefault(key, -1);
    if (value == -1) return -1;
    cache.remove(key);
    cache.put(key, value);
    return value;
  }

  public void put(int key, int value) {
    if (!cache.containsKey(key)) {
      if (capacity == cache.size()) {
        cache.remove(cache.keySet().iterator().next());
      }
    }
    cache.remove(key);
    cache.put(key, value);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
