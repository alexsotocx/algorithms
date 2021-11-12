package amazon.KClosestPoints;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  private double d(int[] p) {
    return Math.sqrt(p[0] * p[0] + p[1] * p[1]);
  }

  public int[][] kClosest(int[][] points, int k) {
    Comparator<int[]> distance = (a, b) -> Double.compare(d(b), d(a));
    PriorityQueue<int[]> pq = new PriorityQueue<>(distance);
    for (int[] p : points) {
      pq.add(p);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[][] res = new int[pq.size()][];
    int i = 0;
    while (!pq.isEmpty()) {
      res[i] = pq.poll();
      i++;
    }
    return res;
  }
}
