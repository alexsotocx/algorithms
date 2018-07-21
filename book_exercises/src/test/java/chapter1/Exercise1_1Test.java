package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Exercise1_1Test {

  @Test
  public void solveWithDataStructure() {
    assertTrue(new Exercise1_1().solveWithDataStructure("asdfghjkl"));
    assertFalse(new Exercise1_1().solveWithDataStructure("aabcde"));
    assertTrue(new Exercise1_1().solveWithDataStructure("123456789asdfghjklzxcvbnm"));
  }

  @Test
  public void solveWithoutDataStructure() {
    assertTrue(new Exercise1_1().solveWithoutDataStructure("asdfghjkl"));
    assertFalse(new Exercise1_1().solveWithoutDataStructure("abbcde"));
    assertTrue(new Exercise1_1().solveWithoutDataStructure("a"));
    assertTrue(new Exercise1_1().solveWithoutDataStructure("abcdefghijklmnopqrst"));
  }
}