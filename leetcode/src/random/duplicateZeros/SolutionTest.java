package random.duplicateZeros;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  @Test
  void duplicateZeros() {
//    int[] arr = new int[]{9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
    int[] arr = new int[]{1,0,2,3,0,4,5,0};

    new Solution().duplicateZeros(arr);
    System.out.println(Arrays.toString(arr));
    assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr);
  }
}
