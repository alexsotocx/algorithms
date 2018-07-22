package chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise1_7Test {

  @Test
  public void transpose() {
    int m= 3, n = 4;
    int[][] mat = new int[][] {
        {1, 2 , 3, 4},
        {10, 11 , 12, 5},
        {9, 8 , 7, 6}
    };

    int[][] expected = new int[][] {
        {9, 10, 1},
        {8, 11, 2},
        {7, 12, 3},
        {6, 5,  4},
    };
    int[][] result = new Exercise1_7().transpose(mat, m, n);
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        assertEquals(result[i][j], expected[i][j]);
      }
    }
  }
}