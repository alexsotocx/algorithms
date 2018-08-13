package chapter8;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class E8_7Test {

  @Test
  public void getPermutations() {
    String[] permutations = new String[]{
        "ABC",
        "ACB",
        "BAC",
        "BCA",
        "CAB",
        "CBA"
    };

    ArrayList<String> output = new E8_7("ABC").getPermutations();
    for (int i = 0; i < permutations.length; i++) {
      assertEquals(output.get(i), permutations[i]);
    }
  }
}