package chapter8;

import org.junit.Test;

import static org.junit.Assert.*;

public class E8_3Test {

  @Test
  public void findMagicNumber() {
//    assertTrue(new MagicIndex().hasMagicIndex(new int[]{-1, 0, 1, 3, 10, 20, 30, 40, 50, 80}));
//    assertFalse(new MagicIndex().hasMagicIndex(new int[]{-1, 0, 1, 2, 10, 20, 30, 40, 50, 80}));
//    assertTrue(new MagicIndex().hasMagicIndex(new int[]{-1, 0, 1, 3, 4, 20, 30, 40, 50, 80}));
    assertTrue(new MagicIndex().hasMagicIndex(new int[]{4,4,4,4,4,4,4,4}));
  }
}
