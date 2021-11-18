package amazon.floodfill;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  private static int[] dx = new int[]{0, 1, 0, -1};
  private static int[] dy = new int[]{1, 0, -1, 0};

  private class Pos {
    int x;
    int y;

    Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int initialColor = image[sr][sc];
    if (initialColor == newColor) return image;
    Queue<Pos> q = new LinkedList<>();
    q.add(new Pos(sr, sc));
    image[sr][sc] = newColor;
    while (!q.isEmpty()) {
      Pos current = q.poll();

      for (int i = 0; i < dx.length; i++) {
        int px = current.x + dx[i];
        int py = current.y + dy[i];

        boolean inside = px >= 0 && px < image.length && py >= 0 && py < image[px].length;
        if (inside && image[px][py] == initialColor) {
          image[px][py] = newColor;
          q.add(new Pos(px, py));
        }
      }
    }
    return image;
  }
}
