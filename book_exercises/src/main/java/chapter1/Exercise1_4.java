package chapter1;

import java.util.HashMap;

public class Exercise1_4 {
  private String permutation;
  public Exercise1_4(String per) {
    this.permutation = per;
  }

  public boolean check() {
    HashMap<Character, Integer> countDict = new HashMap<>();
    for (char c: permutation.toLowerCase().toCharArray()) {
      if(c == ' ') continue;
      countDict.put(c, countDict.getOrDefault(c, 0) + 1);
    }
    boolean oddFound = false;
    for(int v: countDict.values()) {
      if (v % 2 == 1) {
        if (oddFound) return false;
        oddFound = true;
      }
    }
    return true;
  }
}
