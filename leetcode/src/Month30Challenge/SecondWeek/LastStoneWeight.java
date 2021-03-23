package Month30Challenge.SecondWeek;

import java.util.PriorityQueue;

public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
    for (int stone : stones) pq.add(stone);
    while (pq.size() > 1) {
      int p1 = pq.poll();
      int p2 = pq.poll();
      if (p1 - p2 != 0) pq.add(p1 - p2);
    }
    if (pq.size() == 1) return pq.poll();
    return 0;
  }
}
