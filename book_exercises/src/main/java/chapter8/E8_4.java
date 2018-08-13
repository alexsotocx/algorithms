package chapter8;

import java.util.ArrayList;
import java.util.List;

public class E8_4<E> {
  List<List<E>> getSubsets(E[] array) {
    int maxMp = (1 << array.length) - 1;
    List<List<E>> subSets = new ArrayList<>();
    while (maxMp >= 0) {
      int t = maxMp, i = 0;
      List<E> set = new ArrayList<>();
      while (t != 0) {
        if (bitIsSet(t, 0)) set.add(array[i]);
        t >>= 1;
        i++;
      }
      subSets.add(set);
      maxMp--;
    }
    return subSets;
  }

  private boolean bitIsSet(int x, int i) {
    return ((x & (1 << i)) != 0);
  }
}
