package Month30Challenge.SecondWeek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringShiftsTest {

  @Test
  void stringShift() {
    assertEquals("efgabcd", new StringShifts().stringShift("abcdefg",
      new int[][]{
        {1, 1}, {1, 1}, {0, 2}, {1, 3}
      }
    ));
  }
}
