package datastructures;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {
  private int capacity;
  private HashMap<Integer, Integer> freqPerKey = new HashMap<>();
  private HashMap<Integer, Integer> storedCache = new HashMap<>();
  private TreeMap<Integer, Set<Integer>> mapFreqKeys = new TreeMap<>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if(!storedCache.containsKey(key)) {
      if(storedCache.size() == capacity) removeLeastFrequentlyUsed();
    }
    storedCache.put(key, value);
    updateCount(key);
  }

  public int get(int key) {
    if(storedCache.containsKey(key)) {
      updateCount(key);
      return storedCache.get(key);
    }
    return -1;
  }

  private void removeLeastFrequentlyUsed() {
    int leastFrequent = mapFreqKeys.firstKey();
    Set<Integer> lfuSet = mapFreqKeys.get(leastFrequent);
    int key = lfuSet.iterator().next();
    storedCache.remove(key);
    lfuSet.remove(key);
    freqPerKey.remove(key);
    if (lfuSet.isEmpty()) mapFreqKeys.remove(leastFrequent);
  }

  private void updateCount(int key) {
    int countForKey = freqPerKey.getOrDefault(key, 0);
    Set<Integer> elementsPerCount = mapFreqKeys.get(countForKey);
    if (elementsPerCount != null) {
      elementsPerCount.remove(key);
      if (elementsPerCount.isEmpty()) {
        mapFreqKeys.remove(countForKey);
      }
    }
    freqPerKey.put(key, countForKey + 1);
    Set<Integer> newFrequencyCountSet = mapFreqKeys.computeIfAbsent(countForKey + 1, k -> new LinkedHashSet<>());
    newFrequencyCountSet.add(key);
  }


}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
