package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1_3Test {

  @Test
  public void urify() {
    String t = "Mr John Smith    ";
    assertEquals("Mr%20John%20Smith", new Exercise1_3(t, 13).convert());

    t = "  MrJohnSmith    ";
    assertEquals("%20%20MrJohnSmith", new Exercise1_3(t, 13).convert());

    t = "MrJohnSmith";
    assertEquals("MrJohnSmith", new Exercise1_3(t, 11).convert());

    t = "   ";
    assertEquals("%20", new Exercise1_3(t, 1).convert());
  }
}
