package amazon.UniquePaths3;


class Solution {
  private int ways = 0;
  private boolean[][] visited;
  private int dx[] = new int[]{0, 1, 0, -1};
  private int dy[] = new int[]{1, 0, -1, 0};

  public int uniquePathsIII(int[][] grid) {
    ways = 0;
    visited = new boolean[grid.length][grid[0].length];
    int startx = 0;
    int starty = 0;
    int total = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] >= 0) total++;
        if (grid[i][j] == 1) {
          startx = i;
          starty = j;
        }
      }
    }
    findWays(grid, startx, starty, total);
    return ways;
  }

  private void findWays(int[][] grid, int si, int sj, int remain) {
    if (grid[si][sj] == 2 && remain == 1) {
      ways++;
      return;
    }
    int t = grid[si][sj];
    grid[si][sj] = -4;
    remain -= 1;
    for (int i = 0; i < 4; i++) {
      int mi = si + dx[i];
      int mj = sj + dy[i];
      boolean inside = mi >= 0 && mi < grid.length && mj >= 0 && mj < grid[mi].length;
      if (inside && grid[mi][mj] != -4 && grid[mi][mj] != -1) {
        findWays(grid, mi, mj, remain);
      }
    }
    grid[si][sj] = t;
  }
}
