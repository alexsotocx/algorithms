package chapter8;

import java.util.Stack;

public class E8_2 {
  private static final int[] di = {0, 1}, dj = {1, 0};
  private static final char[] movements = {'R', 'D'};
  private static final int VISITED = 1, BLOCKED = -1, AVAILABLE = 0;

  private int r, c;
  private int grid[][];
  private Stack<Character> robotPath;

  public E8_2(int r, int c, int[][] grid) {
    this.r = r;
    this.c = c;
    this.grid = grid;
    this.robotPath = new Stack<>();
  }

  String path() {
    calculatePath(0, 0);
    StringBuilder sb = new StringBuilder(robotPath.size());
    while (!robotPath.isEmpty()) sb.append(robotPath.pop());
    return sb.toString();
  }

  private boolean calculatePath(int si, int sj) {
    if (si == r - 1 && sj == c - 1) return true;
    grid[si][sj] = VISITED;
    for (int i = 0; i < di.length; i++) {
      int vi = di[i] + si, vj = dj[i] + sj;
      if (canVisit(vi, vj)) {
        if (calculatePath(vi, vj)) {
          robotPath.push(movements[i]);
          return true;
        }
      }
    }
    return false;
  }

  private boolean canVisit(int i, int j) {
    if (i >= r || j >= c) return false;
    return grid[i][j] == AVAILABLE;
  }
}
