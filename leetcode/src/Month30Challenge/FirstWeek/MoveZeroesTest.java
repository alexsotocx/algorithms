package Month30Challenge.FirstWeek;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MoveZeroesTest {

  @Test
  void moveZeroes() {
    int[] nums = new int[]{0, 1, 0, 3, 12};
    new MoveZeroes().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[]{0, 0, 1};
    new MoveZeroes().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
