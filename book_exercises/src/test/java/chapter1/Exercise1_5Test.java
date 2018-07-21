package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Exercise1_5Test {
  @Test
  public void isOneWay() {
    assertTrue(new Exercise1_5().isOneWay("pale", "ple"));
    assertTrue(new Exercise1_5().isOneWay("pales", "pale"));
    assertTrue(new Exercise1_5().isOneWay("pale", "bale"));
    assertFalse(new Exercise1_5().isOneWay("pale", "bae"));

    assertTrue(new Exercise1_5().isOneWay("a", "b"));
    assertTrue(new Exercise1_5().isOneWay("a", ""));
  }
}