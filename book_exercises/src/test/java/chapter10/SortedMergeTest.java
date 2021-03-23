package chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortedMergeTest {

  @Test
  void sort() {
    int a[] = new int[]{2, 5, 10, 20, 0, 0, 0};
    int b[] = new int[]{1, 4, 10};
    new SortedMerge().sort(a, b, 3);
    assertArrayEquals(new int[]{1, 2, 4, 5, 10, 10, 20}, a);

    a = new int[]{10, 11, 12, 20, 0, 0, 0};
    b = new int[]{1, 4, 10};
    new SortedMerge().sort(a, b, 3);
    assertArrayEquals(new int[]{1, 4, 10, 10, 11, 12, 20}, a);

    a = new int[]{1, 4, 10, 0, 0, 0, 0};
    b = new int[]{20, 30, 40, 50};
    new SortedMerge().sort(a, b, 2);
    assertArrayEquals(new int[]{1, 4, 10, 20, 30, 40, 50}, a);
  }
}
