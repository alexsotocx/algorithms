package amazon.snakesAndLadders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void getRow() {
    Solution s = new Solution();
    assertEquals(5, s.getRow(6, 1));
    assertEquals(5, s.getRow(6, 3));
    assertEquals(5, s.getRow(6, 6));

    assertEquals(3, s.getRow(6, 13));
    assertEquals(3, s.getRow(6, 16));
    assertEquals(3, s.getRow(6, 18));

    assertEquals(0, s.getRow(6, 36));
    assertEquals(0, s.getRow(6, 33));
    assertEquals(0, s.getRow(6, 31));
  }

  @Test
  void getCol() {
    Solution s = new Solution();
    assertEquals(0, s.getCol(6, 1));
    assertEquals(2, s.getCol(6, 3));
    assertEquals(5, s.getCol(6, 6));

    assertEquals(0, s.getCol(6, 13));
    assertEquals(3, s.getCol(6, 16));
    assertEquals(5, s.getCol(6, 18));

    assertEquals(0, s.getCol(6, 36));
    assertEquals(1, s.getCol(6, 35));
    assertEquals(4, s.getCol(6, 32));
  }

  @Test
  void snakesAndLadders() {
    int[][] board = new int[][]{
      {-1, -1, -1, 46, 47, -1, -1, -1}, {51, -1, -1, 63, -1, 31, 21, -1}, {-1, -1, 26, -1, -1, 38, -1, -1}, {-1, -1, 11, -1, 14, 23, 56, 57}, {11, -1, -1, -1, 49, 36, -1, 48}, {-1, -1, -1, 33, 56, -1, 57, 21}, {-1, -1, -1, -1, -1, -1, 2, -1}, {-1, -1, -1, 8, 3, -1, 6, 56}
    };
    assertEquals(4, new Solution().snakesAndLadders(board));
  }
}
