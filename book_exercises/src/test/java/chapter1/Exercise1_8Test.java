package chapter1;

import org.junit.Test;

import java.util.Arrays;

public class Exercise1_8Test {
  @Test
  public void testReplace() {
    int[][] x = new int[][]{
      {1, 2, 4, 1, 1},
      {3, 7, 8, 9, 2},
      {0, 3, 5, 6, 2},
      {1, 1, 2, 3, 2}
    };

    new Exercise1_8(x).replace();
    for(int i = 0; i < x.length; i++) {
      System.out.println(Arrays.toString(x[i]));
    }
  }
}
