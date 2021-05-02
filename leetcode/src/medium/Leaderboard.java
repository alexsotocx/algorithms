package medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

class Leaderboard {
  HashMap<Integer, Integer> scorePerPlayer;

  public Leaderboard() {
    scorePerPlayer = new HashMap<>();
  }

  public void addScore(int playerId, int score) {
    scorePerPlayer.compute(playerId, (key, val) -> (val == null) ? score : val + score);
  }

  public int top(int K) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Iterator<Integer> iterator1 = scorePerPlayer.values().iterator();
    int i = 0;
    while (iterator1.hasNext() && i < K) {
      i++;
      minHeap.add(iterator1.next());
    }

    while (iterator1.hasNext()) {
      int val = iterator1.next();
      if (minHeap.peek() <= val) {
        minHeap.poll();
        minHeap.add(val);
      }
    }
    return minHeap.stream().reduce((integer, integer2) -> integer + integer2).get();
  }


  public void reset(int playerId) {
    scorePerPlayer.remove(playerId);
  }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
