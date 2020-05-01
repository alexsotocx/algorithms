package datastructures;

import java.util.*;
public class RandomizedCollectionHash {
  private HashMap<Integer, Set<Integer>> map = new HashMap<>();
  private ArrayList<Integer> list = new ArrayList<>();


  /** Initialize your data structure here. */
  public RandomizedCollectionHash() {

  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int data) {
    Set<Integer> st = map.get(data);
    boolean contained = st != null;
    if (!contained) { st = new LinkedHashSet<>(); map.put(data, st); }
    st.add(list.size());
    list.add(data);
    return !contained;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int data) {
    Set<Integer> st = map.get(data);
    if (st == null) return false;
    int posDelete = st.iterator().next();
    st.remove(posDelete);
    if(st.isEmpty()) map.remove(data);
    int currentSize = list.size() - 1;
    if (posDelete != currentSize) {
      Set<Integer> lastElementStack = map.get(list.get(currentSize));
      lastElementStack.remove(currentSize);
      lastElementStack.add(posDelete);
      Collections.swap(list, posDelete, currentSize);
    }
    list.remove(currentSize);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return list.get(new Random().nextInt(list.size()));
  }
}
