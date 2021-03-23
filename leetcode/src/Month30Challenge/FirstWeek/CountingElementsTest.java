package Month30Challenge.FirstWeek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingElementsTest {
  @Test
  void countElements() {
    assertEquals(2, new CountingElements().countElements(new int[]{1, 2, 3}));
    assertEquals(0, new CountingElements().countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
    assertEquals(3, new CountingElements().countElements(new int[]{1, 3, 2, 3, 5, 0}));
    assertEquals(2, new CountingElements().countElements(new int[]{1, 1, 2, 2}));
    assertEquals(2, new CountingElements().countElements(new int[]{1, 1, 2}));
  }
}
