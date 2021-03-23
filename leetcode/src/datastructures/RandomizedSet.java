package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/
 */
class RandomizedSet {
  private ArrayList<Integer> list = new ArrayList<>();
  private HashMap<Integer, Integer> map = new HashMap<>();

  /** Initialize your data structure here. */
  public RandomizedSet() {

  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int data) {
    if (!map.containsKey(data)) {
      map.put(data, list.size());
      list.add(data);
      return true;
    }
    return false;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int data) {
    if (map.containsKey(data)) {
      int position = map.get(data);
      map.remove(data);
      if (position != list.size() - 1) {
        Collections.swap(list, position, list.size() - 1);
        map.put(list.get(position), position);
      }
      list.remove(list.size() - 1);
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(new Random().nextInt(list.size()));
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
