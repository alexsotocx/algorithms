package chapter5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongOneSubsequenceTest {

  @Test
  void longest() {
    assertEquals(8, new LongOneSubsequence().longest(1775));
    assertEquals(1, new LongOneSubsequence().longest(0));
    assertEquals(1, new LongOneSubsequence().longest(1));
  }
}
