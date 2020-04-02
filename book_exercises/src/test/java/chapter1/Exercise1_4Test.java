package chapter1;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Exercise1_4Test {
  @Test()
  public void testCheck() {
    assertTrue(new Exercise1_4("Tact Coa").check());
    assertTrue(new Exercise1_4("aaa").check());
    assertTrue(new Exercise1_4("aab aa").check());
    assertTrue(new Exercise1_4("aabb aa").check());
    assertFalse(new Exercise1_4("aabbb a").check());
  }
}
