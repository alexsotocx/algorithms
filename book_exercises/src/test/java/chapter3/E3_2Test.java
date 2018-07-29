package chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E3_2Test {

  @Test
  public void min() {
    E3_2 stackMin = new E3_2();
    stackMin.push(10);
    stackMin.push(5);
    stackMin.push(3);
    stackMin.push(6);
    stackMin.push(1);

    assertEquals(1, stackMin.min().intValue());
    assertEquals(1, stackMin.pop().intValue());
    assertEquals(3, stackMin.min().intValue());
    assertEquals(6, stackMin.pop().intValue());
    assertEquals(3, stackMin.min().intValue());
  }
}