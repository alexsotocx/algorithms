package amazon.hitCounter;

import java.util.LinkedList;

class HitCounter {

  private LinkedList<Integer> q;

  public HitCounter() {
    q = new LinkedList<>();
  }

  public void hit(int timestamp) {
    q.addLast(timestamp);
    removeLastFiveTimestamp(timestamp);
  }

  private void removeLastFiveTimestamp(int tp) {
    int t = Math.max(tp - 300, 0);
    while (!q.isEmpty() && q.getFirst() <= t) q.removeFirst();
  }

  public int getHits(int timestamp) {
    removeLastFiveTimestamp(timestamp);
    return q.size();
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
