package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise1_3Test {

  @Test
  public void urify() {
    char[] t = "Mr John Smith    ".toCharArray();
    new Exercise1_3().urify(13, t);
    assertEquals("Mr%20John%20Smith", new String(t));

    t = "  MrJohnSmith    ".toCharArray();
    new Exercise1_3().urify(13, t);
    assertEquals("%20%20MrJohnSmith", new String(t));

    t = "MrJohnSmith".toCharArray();
    new Exercise1_3().urify(13, t);
    assertEquals("MrJohnSmith", new String(t));

    t = "   ".toCharArray();
    new Exercise1_3().urify(1, t);
    assertEquals("%20", new String(t));
  }
}