package amazon.maxIncreaseKeepingSkyline;

class Solution {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] rowMax = new int[grid.length];
    int[] colMax = new int[grid.length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        rowMax[i] = Math.max(grid[i][j], rowMax[i]);
        colMax[j] = Math.max(grid[i][j], colMax[j]);
      }
    }
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int maxV = Math.min(rowMax[i], colMax[j]);
        if (grid[i][j] < maxV) max += maxV - grid[i][j];
      }
    }

    return max;
  }
}
