package mockinterviews;

public class E1 {
}

class Main {
  static int m = 4;
  static int n = 4;
  static int[][] mat = new int[][]{
      {1, 1, 0, 0},
      {0, 1, 0, 0},
      {0, 0, 1, 0},
      {1, 0, 0, 0}
  };

  static boolean[][] visited;
  static int[] di = new int[]{0, -1, 0, 1};
  static int[] dj = new int[]{1, 0, -1, 0};

  static int dfs(int starti, int startj) {
    int flood = 1;
    visited[starti][startj] = true;
    for (int i = 0; i < di.length; i++) {
      int dii = di[i] + starti;
      int dij = dj[i] + startj;
      if (dii < 0 || dii >= m) continue;
      if (dij < 0 || dij >= n) continue;
      if (!visited[dii][dij] && mat[dii][dij] == 1) {
        flood += dfs(dii, dij);
      }
    }
    return flood;
  }

  static public void main(String args[]) {
    visited = new boolean[m][n];
    int maxFlood = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && mat[i][j] == 1) {
          maxFlood = Math.max(maxFlood, dfs(i, j));
        }
      }
    }

    System.out.println(maxFlood);
  }
}
