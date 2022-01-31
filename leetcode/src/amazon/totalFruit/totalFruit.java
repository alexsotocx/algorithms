package amazon.totalFruit;

import java.util.*;

class Solution {
  private class Entry {
    int f, p;

    public Entry(int f, int p) {
      this.f = f;
      this.p = p;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Entry entry = (Entry) o;
      return f == entry.f;
    }

    @Override
    public int hashCode() {
      return Objects.hash(f);
    }
  }

  public int totalFruit(final int[] fruits) {
    int max = 0;
    LinkedList<Entry> basketType = new LinkedList<>();
    basketType.add(new Entry(fruits[0], 0));
    int prev = fruits[0];
    int windowStart = 0;
    for(int i = 0; i < fruits.length; i++){
      Entry entry = new Entry(fruits[i], i);
      boolean contained = basketType.contains(entry);
      if(contained && prev == fruits[i]) continue;
      basketType.remove(entry);
      basketType.add(entry);
      prev = fruits[i];
      if (basketType.size() == 3) {
        Entry entryD = basketType.getFirst();
        basketType.remove(entryD);
        max = Math.max(max, i - windowStart);
        windowStart = basketType.getFirst().p;
      }
    }
    max = Math.max(max, fruits.length - windowStart);
    return max;
  }
}
