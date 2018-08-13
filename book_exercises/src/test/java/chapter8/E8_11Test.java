package chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E8_11Test {

  @Test
  public void change() {
    E8_11 changer = new E8_11(25, 10, 5, 1);
    assertEquals(1, changer.change(1));
    assertEquals(1, changer.change(2));
    assertEquals(2, changer.change(5));
    assertEquals(2, changer.change(6));
  }
}