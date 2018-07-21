package chapter1;

import java.util.HashSet;

/*
Create an algorithm to determine if a word has all unique characters.
* */
public class Exercise1_1 {
  public boolean solveWithDataStructure(String word) {
    HashSet<Character> elements = new HashSet<>();
    for (char c : word.toCharArray()) {
      if (elements.contains(c)) return false;
      elements.add(c);
    }

    return true;
  }

  public boolean solveWithoutDataStructure(String word) {
    long bitMask = 0;
    for (char c : word.toCharArray()) {
      int lowercaseC = (c | 32);
      int bit = (1 << (lowercaseC - 'a'));
      if ((bitMask & bit) != 0) return false;
      bitMask |= bit;
    }
    return true;
  }
}
