package chapter8;

import org.junit.Test;

import static org.junit.Assert.*;

public class E8_2Test {

  @Test
  public void path() {
    int[][] grid = new int[][] {
        {0,   0, 0, 0},
        {-1,  -1, -1, 0},
        {0, 0, -1, 0},
        {0, 0, -1, 0},
        {0, 0, -1, 0}
    };
    int r = grid.length;
    int c = grid[0].length;
    assertEquals("RRRDDDD", new E8_2(r, c, grid).path());
  }
}