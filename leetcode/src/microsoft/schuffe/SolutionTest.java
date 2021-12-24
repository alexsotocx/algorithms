package microsoft.schuffe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

  @Test
  void shuffle() {
    System.out.println(Arrays.toString(new Solution().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
  }
}
