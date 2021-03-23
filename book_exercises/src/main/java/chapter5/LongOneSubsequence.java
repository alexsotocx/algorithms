package chapter5;

import java.util.ArrayList;

public class LongOneSubsequence {
  public int longest(int num) {
    int max = 1;
    ArrayList<Integer> bits = new ArrayList<>();
    while (num != 0) {
      if ((num & 1) == 0) {
        num >>= 1;
        bits.add(0);
      } else {
        int count = 0;
        while ((num & 1) == 1) {
          count++;
          num >>= 1;
        }
        bits.add(count);
      }
    }
    for (int i = 0; i < bits.size(); i++) {
      if (bits.get(i) != 0) max = Math.max(max, bits.get(i));
      else {
        int count = 1;
        if (i - 1 >= 0) count += bits.get(i - 1);
        if (i + 1 < bits.size()) count += bits.get(i + 1);
        max = Math.max(max, count);
      }
    }
    return max;
  }
}
