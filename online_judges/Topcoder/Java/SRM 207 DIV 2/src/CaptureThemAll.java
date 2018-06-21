import java.util.LinkedList;
import java.util.Queue;

public class CaptureThemAll {
  //(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (1, -2), (-1, 2) or (1, 2)
  int deltaX[] = {-2, -2, 2, 2, -1, 1, -1, 1};
  int deltaY[] = {-1, 1, -1, 1, -2, -2, 2, 2};

  public int fastKnight(String knight, String rook, String queen) {

    Position knightPosition = new Position(knight);
    Position queenPosition = new Position(queen);
    Position rocktPosition = new Position(rook);
    return Math.min(bfs(knightPosition, queenPosition) + bfs(queenPosition, rocktPosition), bfs(knightPosition, rocktPosition) + bfs(rocktPosition, queenPosition));
  }

  public int bfs(Position start, Position finish) {
    int[][] distance = new int[8][8];
    distance[start.r][start.c] = 0;
    Queue<Position> queue = new LinkedList<Position>();
    queue.offer(start);
    while (!queue.isEmpty()) {
      start = queue.poll();
      if (start.equals(finish)) {
        return distance[start.r][start.c];
      }
      for (int i = 0; i < deltaX.length; i++) {
        Position newPosition = start.move(deltaX[i], deltaY[i]);
        if (newPosition.isValid() && distance[newPosition.r][newPosition.c] == 0) {
          queue.offer(newPosition);
          distance[newPosition.r][newPosition.c] = 1 + distance[start.r][start.c];
        }
      }
    }
    return Integer.MAX_VALUE;
  }

  public class Position {
    int c, r;

    public Position(String pos) {
      c = pos.charAt(0) - 'a';
      r = pos.charAt(1) - '1';
    }

    public Position(int c, int r) {
      this.c = c;
      this.r = r;
    }

    public Position move(int dx, int dy) {
      Position newPosition = new Position(this.c, this.r);
      newPosition.c += dy;
      newPosition.r += dx;
      return newPosition;
    }

    public boolean isValid() {
      return (this.c >= 0 && this.c < 8) && (this.r >= 0 && this.r < 8);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof Position && ((Position) obj).r == this.r && ((Position) obj).c == this.c;
    }
  }
}
