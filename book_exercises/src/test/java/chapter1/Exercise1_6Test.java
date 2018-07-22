package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1_6Test {

  @Test
  public void compress() {
    assertEquals(new Exercise1_6().compress("aabcccccaaa"), "a2b1c5a3");
    assertEquals(new Exercise1_6().compress("a"), "a");
    assertEquals(new Exercise1_6().compress("aab"), "aab");
    assertEquals(new Exercise1_6().compress("aaaab"), "a4b1");
  }
}