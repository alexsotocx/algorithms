package chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E8_10Test {

  @Test
  public void paint() {
    char[][] grid = new char[][]{
      "oowww".toCharArray(),
      "cwwwo".toCharArray(),
      "cgwww".toCharArray(),
      "cwgbb".toCharArray(),
      "ccccb".toCharArray()
    };
    E8_10 painter = new E8_10(grid);
    assertEquals(9, painter.paint(0, 2, 'b'));
    assertEquals(12, painter.paint(0, 2, 'x'));
  }
}
