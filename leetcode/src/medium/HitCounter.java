package medium;

import java.util.LinkedList;
import java.util.Queue;

class HitCounter {

  private Queue<Integer> hitsIntheLastFive;

  /**
   * Initialize your data structure here.
   */
  public HitCounter() {
    hitsIntheLastFive = new LinkedList<>();
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    hitsIntheLastFive.add(timestamp);
    this.removeEverythingBefore(timestamp - 300);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    this.removeEverythingBefore(timestamp - 300);
    return hitsIntheLastFive.size();
  }

  private void removeEverythingBefore(int timestamp) {
    while (!hitsIntheLastFive.isEmpty() && hitsIntheLastFive.peek() <= timestamp) hitsIntheLastFive.poll();
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
