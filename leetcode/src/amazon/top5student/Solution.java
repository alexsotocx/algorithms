package amazon.top5student;

import java.util.*;

class Solution {
  public int[][] highFive(int[][] items) {
    HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for(int[] sScore: items) {
      int studentId = sScore[0];
      int score = sScore[1];
      PriorityQueue<Integer> pq = map.computeIfAbsent(studentId, integer -> new PriorityQueue<>());
      pq.add(score);
      if(pq.size() > 5) pq.poll();
    }
    int[][] ans = new int[map.size()][2];
    int i = 0;
    for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
      int k = entry.getKey();
      PriorityQueue<Integer> pq = entry.getValue();
      int average = pq.stream().reduce(0, Integer::sum) / 5;
      ans[i][0] = k;
      ans[i][1] = average;
      i++;
    }
    Arrays.sort(ans, Comparator.comparingInt(o -> o[0]));
    return ans;
  }
}
