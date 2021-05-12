package medium;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class FindClosestPointsToOrigin {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Point> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int[] p : points) {
      pq.add(new Point(p));
      while (pq.size() > k) pq.poll();
    }
    int[][] response = new int[pq.size()][];
    int i = 0;
    Iterator<Point> it = pq.iterator();
    while (it.hasNext()) {
      response[i] = it.next().primitive;
      i++;
    }
    return response;
  }

  private class Point implements Comparable<Point> {
    int[] primitive;
    double distanceToCenter;

    Point(int[] p) {
      this.primitive = p;
      this.distanceToCenter = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
    }


    public int compareTo(Point o) {
      return Double.compare(distanceToCenter, o.distanceToCenter);
    }
  }
}
