package amazon.totalFruit;


import java.util.LinkedList;

class Solution {
  private class Entry {
    int f, p;

    public Entry(int f, int p) {
      this.f = f;
      this.p = p;
    }
  }

  public int totalFruit(final int[] fruits) {
    int max = 0;
    LinkedList<Entry> basketType = new LinkedList<>();
    basketType.add(new Entry(fruits[0], 0));
    int windowStart = 0;
    for(int i = 0; i < fruits.length; i++){
      if(basketType.getLast().f == fruits[i]) continue;
      if(basketType.getFirst().f == fruits[i]) basketType.removeFirst();
      basketType.add(new Entry(fruits[i], i));
      if (basketType.size() == 3) {
        basketType.removeFirst();
        max = Math.max(max, i - windowStart);
        windowStart = basketType.getFirst().p;
      }
    }
    max = Math.max(max, fruits.length - windowStart);
    return max;
  }
}
