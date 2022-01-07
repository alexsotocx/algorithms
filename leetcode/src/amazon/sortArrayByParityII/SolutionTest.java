package amazon.sortArrayByParityII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

  @Test
  void sortArrayByParityII() {
    int[] nums = new int[]{5, 2, 4, 7};
    int[] x = new Solution().sortArrayByParityII(nums);
    System.out.println(Arrays.toString(x));
  }
}
