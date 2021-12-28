package amazon.infixBinaryExpression;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void expTree() {
    System.out.println(new Solution().expTree("3*4*(5+2-2+3)"));
  }
}
