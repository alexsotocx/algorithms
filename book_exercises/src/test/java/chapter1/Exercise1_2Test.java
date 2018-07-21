package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Exercise1_2Test {

  @Test
  public void isPermutation() {
    assertTrue(new Exercise1_2().isPermutation("abcd", "dcba"));
    assertFalse(new Exercise1_2().isPermutation("abcd", "dcea"));
    assertFalse(new Exercise1_2().isPermutation("abcd", "dcbe"));
    assertTrue(new Exercise1_2().isPermutation("abcd", "abcd"));
    assertTrue(new Exercise1_2().isPermutation("a", "a"));
    assertFalse(new Exercise1_2().isPermutation("b", "a"));
    assertFalse(new Exercise1_2().isPermutation("ab", "abc"));
  }
}