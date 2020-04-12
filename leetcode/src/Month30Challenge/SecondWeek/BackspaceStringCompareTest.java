package Month30Challenge.SecondWeek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BackspaceStringCompareTest {

  @Test
  void backspaceCompare() {
    assertTrue(new BackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
  }
}
