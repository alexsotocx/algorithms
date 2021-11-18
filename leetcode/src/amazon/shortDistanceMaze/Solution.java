package amazon.shortDistanceMaze;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  private static int[] dx = new int[]{0, 1, 0, -1};
  private static int[] dy = new int[]{1, 0, -1, 0};

  private class Pos {
    int x;
    int y;
    int d;

    Pos(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }

  private int[] findNextWallInDirection(int dir, int x, int y, int[][] maze) {
    int j = 1;
    while (true) {
      int px = x + dx[dir] * j;
      int py = y + dy[dir] * j;
      boolean inside = px >= 0 && px < maze.length && py >= 0 && py < maze[px].length;
      if (!inside || maze[px][py] == 1) break;
      j++;
    }
    j--;
    int px = x + dx[dir] * j;
    int py = y + dy[dir] * j;
    return new int[]{px, py, j};
  }

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    PriorityQueue<Pos> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.d));
    int[][] distance = new int[maze.length][maze[0].length];
    for (int[] m : distance) {
      Arrays.fill(m, Integer.MAX_VALUE);
    }
    distance[start[0]][start[1]] = 0;
    q.add(new Pos(start[0], start[1], 0));
    while (!q.isEmpty()) {
      Pos c = q.poll();

      if (distance[c.x][c.y] < c.d) continue;
      for (int i = 0; i < dx.length; i++) {
        int[] nextWall = findNextWallInDirection(i, c.x, c.y, maze);
        int px = nextWall[0];
        int py = nextWall[1];
        int d = nextWall[2];
        if (distance[px][py] > d + c.d) {
          distance[c.x][c.y] = c.d;
          q.add(new Pos(px, py, d + c.d));
        }
      }
    }
    return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
  }
}
