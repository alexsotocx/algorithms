package chapter8;

public class E8_10 {
  private char[][] grid;
  private static final byte[] di = {0, 1, 0, -1};
  private static final byte[] dj = {1, 0, -1, 0};

  public E8_10(char[][] grid) {
    this.grid = grid;
  }

  public int paint(int r, int c, char color) {
    return paint(r, c, grid[r][c], color);
  }

  private int paint(int r, int c, char oldColor, char newColor) {
    int painted = 1;
    grid[r][c] = newColor;
    for (int i = 0; i < di.length; i++) {
      int vi = r + di[i], vj = c + dj[i];
      if (canBePainted(vi, vj, oldColor)) painted += paint(vi, vj, oldColor, newColor);
    }
    return painted;
  }

  private boolean canBePainted(int i, int j, char color) {
    return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == color;
  }
}
