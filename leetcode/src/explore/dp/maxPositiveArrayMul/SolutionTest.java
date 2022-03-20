package explore.dp.maxPositiveArrayMul;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void getMaxLen() {
    assertEquals(8, new Solution().getMaxLen(new int[]{5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2}));
  }
}
