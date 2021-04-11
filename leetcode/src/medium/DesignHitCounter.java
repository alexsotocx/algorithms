package medium;

import java.util.HashMap;

class HitCounterSlow {

  private HashMap<Integer, Integer> hitsPerTimestamp;

  /**
   * Initialize your data structure here.
   */
  public HitCounterSlow() {
    hitsPerTimestamp = new HashMap<Integer, Integer>();
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    hitsPerTimestamp.compute(timestamp, (key, val) -> {
      if (val == null) return 1;
      return val + 1;
    });
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    int hits = 0;
    for (int i = Math.max(timestamp - 299, 0); i <= timestamp; i++) {
      hits += hitsPerTimestamp.getOrDefault(i, 0);
    }

    return hits;
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
