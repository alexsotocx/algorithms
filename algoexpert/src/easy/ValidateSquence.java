package easy;

import java.util.*;

class ValidateSequence {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int p1 = 0;
    int aSize = array.size();
    int sSize = sequence.size();
    if (sSize > aSize) return false;

    for (Integer integer : sequence) {
      while (p1 < aSize && !array.get(p1).equals(integer)) p1++;
      if (p1 == aSize) return false;
      p1++;
    }

    return true;
  }
}

