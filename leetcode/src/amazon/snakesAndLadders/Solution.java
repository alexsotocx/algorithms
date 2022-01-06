package amazon.snakesAndLadders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int snakesAndLadders(int[][] board) {
    Queue<Integer> nextPos = new LinkedList<>();
    int n = board.length;
    int[] distance = new int[n * n + 1];
    Arrays.fill(distance, -1);
    nextPos.add(1);
    distance[1] = 0;
    while (!nextPos.isEmpty()) {
      int curr = nextPos.poll();
      if (curr == n * n) {
        return distance[curr];
      }
      for (int i = 1; i <= 6; i++) {
        int next = curr + i;
        if (next > n * n) break;
        int r = getRow(n, next);
        int c = getCol(n, next);
        int snakeLader = board[r][c];
        if (snakeLader != -1) next = snakeLader;
        if (distance[next] == -1) {
          nextPos.offer(next);
          distance[next] = distance[curr] + 1;
        }
      }
    }
    return -1;
  }

  int getRow(int n, int num) {
    int s = (num - 1) / n;
    return n - s - 1;
  }

  int getCol(int n, int num) {
    int r = getRow(n, num);
    int x = n - r;
    int cover = (x - 1) * n;
    int regular = num - cover - 1;
    if (x % 2 == 0) {
      return n - regular - 1;
    } else {
      return regular;
    }
  }
}
