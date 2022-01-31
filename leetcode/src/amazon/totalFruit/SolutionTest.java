package amazon.totalFruit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void totalFruit() {
    assertEquals(5, new Solution().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
  }
}
