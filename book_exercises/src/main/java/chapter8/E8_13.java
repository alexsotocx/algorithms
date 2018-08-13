package chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Box implements Comparable<Box> {
  public int h, w, d;

  public Box(int w, int d, int h) {
    this.h = h;
    this.w = w;
    this.d = d;
  }

  public boolean canBeAtBottomOf(Box b) {
    return h > b.h && w > b.w && d > b.d;
  }

  @Override
  public int compareTo(Box o) {
    return o.h - h;
  }
}

public class E8_13 {

  private ArrayList<Box> boxes;
  private int memo[];

  public E8_13(ArrayList<Box> boxes) {
    this.boxes = boxes;
    Collections.sort(boxes);
    memo = new int[boxes.size()];
    Arrays.fill(memo, -1);
  }

  public int maxHeight() {
    return maxHeight(0);
  }

  private int maxHeight(int b) {
    if (memo[b] != -1) return memo[b];
    Box current = boxes.get(b);
    int max = current.h;
    for (int i = b + 1; i < boxes.size(); i++) {
      int t = maxHeight(i);
      if (current.canBeAtBottomOf(boxes.get(i))) {
        max = Math.max(t + current.h, max);
      } else {
        max = Math.max(t, max);
      }
    }

    return memo[b] = max;
  }

}
