package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>> {
  private ArrayList<T> elements = new ArrayList<>();

  public void push(T data) {
    elements.add(data);
    shiftUp(elements.size() - 1);
  }

  private void shiftUp(int index) {
    while (index > 0 && elements.get(parentIndex(index)).compareTo(elements.get(index)) < 0) {
      int parent = parentIndex(index);
      Collections.swap(elements, parent, index);
      index = parent;
    }
  }

  public T pop() {
    T temp = elements.get(0);
    if (elements.size() <= 1) return temp;
    T last = elements.get(elements.size() - 1);
    elements.set(0, last);
    elements.remove(elements.size() - 1);
    shiftDown(0);
    return temp;
  }

  private void shiftDown(int index) {
    int n = elements.size();
    while (leftIndex(index) < n) {
      int right = rightIndex(index);
      int left = leftIndex(index);
      int bigger = left;
      T current = elements.get(index);
      if (right < n && elements.get(right).compareTo(elements.get(left)) > 0) bigger = right;
      if (elements.get(bigger).compareTo(current) <= 0) break;
      Collections.swap(elements, bigger, index);
      index = bigger;
    }
  }

  private int leftIndex(int n) {
    return 2 * n + 1;
  }

  private int rightIndex(int n) {
    return leftIndex(n) + 1;
  }

  private int parentIndex(int n) {
    return (n - 1) / 2;
  }
}
