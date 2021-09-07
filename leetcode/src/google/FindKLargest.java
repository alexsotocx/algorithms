package google;

import java.util.PriorityQueue;

public class FindKLargest {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for(int n: nums) {
      if (q.size() < k) {
        q.add(n);
      } else {
        if (q.peek() < n) {
          q.poll();
          q.add(n);
        }
      }
    }
    return q.peek();
  }
}
