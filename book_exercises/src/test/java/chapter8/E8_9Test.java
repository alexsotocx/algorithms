package chapter8;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class E8_9Test {

  @Test
  public void generate() {
    String[] output = new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
    HashSet<String> validp = new E8_9().generate(3);
    for (String s : output) {
      assertTrue(validp.contains(s));
    }

    assertEquals(output.length, validp.size());
  }
}