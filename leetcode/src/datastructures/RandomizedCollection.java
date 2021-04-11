package datastructures;

import java.util.*;

public class RandomizedCollection {
  private HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
  private ArrayList<Integer> list = new ArrayList<>();


  /**
   * Initialize your data structure here.
   */
  public RandomizedCollection() {

  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int data) {
    PriorityQueue<Integer> st = map.get(data);
    boolean contained = st != null;
    if (!contained) {
      st = new PriorityQueue<>((o1, o2) -> o2 - o1);
      map.put(data, st);
    }
    st.add(list.size());
    list.add(data);
    return !contained;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int data) {
    PriorityQueue<Integer> st = map.get(data);
    if (st == null) return false;
    int lastPositionData = st.poll();
    if (st.isEmpty()) map.remove(data);
    if (lastPositionData != list.size() - 1) {
      PriorityQueue<Integer> lastElementStack = map.get(list.get(list.size() - 1));
      lastElementStack.poll();
      lastElementStack.add(lastPositionData);
      Collections.swap(list, lastPositionData, list.size() - 1);
    }
    list.remove(list.size() - 1);
    return true;
  }

  /**
   * Get a random element from the collection.
   */
  public int getRandom() {
    return list.get(new Random().nextInt(list.size()));
  }
}
