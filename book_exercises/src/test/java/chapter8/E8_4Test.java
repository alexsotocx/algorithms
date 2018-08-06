package chapter8;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class E8_4Test {

  @Test
  public void getSubsets() {
    List<List<Character>> subsets = new E8_4<Character>().getSubsets(new Character[]{'A', 'B', 'C', 'D', 'F'});
    for(List<Character> subset : subsets) {
      System.out.println(subset);
    }
  }
}