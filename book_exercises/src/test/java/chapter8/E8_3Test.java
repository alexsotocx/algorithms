package chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E8_3Test {

  @Test
  public void findMagicNumber() {
    assertEquals(3, new E8_3().findMagicNumber(new int[]{-1, 0, 1, 3, 10, 20, 30, 40, 50, 80}));
    assertEquals(-1, new E8_3().findMagicNumber(new int[]{-1, 0, 1, 2, 10, 20, 30, 40, 50, 80}));
    assertEquals(4, new E8_3().findMagicNumber(new int[]{-1, 0, 1, 3, 4, 20, 30, 40, 50, 80}));
    // assertEquals(4, new E8_3().findMagicNumber(new int[]{4,4,4,4,4,4,4,4}));
  }
}