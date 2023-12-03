package arrays.medium;

import java.util.*;

public class moveElementToEnd {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int pEnd = array.size() - 1;
    int pStart = 0;
    while(pStart < pEnd) {
      if (array.get(pEnd) == toMove) {
        pEnd--;
        continue;
      }
      if (array.get(pStart) == toMove) {
        int t = array.get(pStart);
        array.set(pStart, array.get(pEnd));
        array.set(pEnd, t);
        pEnd--;
      }

      pStart++;
    }
    return array;
  }
}
