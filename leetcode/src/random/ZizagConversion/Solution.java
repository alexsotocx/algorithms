package random.ZizagConversion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    List<List<Character>> z = new ArrayList<>();
    for (int i = 0; i < Math.min(s.length(), numRows); i++) {
      z.add(new LinkedList<>());
    }

    StringBuilder sb = new StringBuilder();
    int position = 0;
    int increase = -1;
    for (int i = 0; i < s.length(); i++) {
      if (position == numRows  - 1 || position == 0) {
        increase *= -1;
      }
      z.get(position).add(s.charAt(i));
      position += increase;
    }
    for (List<Character> l : z) {
      for (char c : l) sb.append(c);
    }
    return sb.toString();
  }
}
