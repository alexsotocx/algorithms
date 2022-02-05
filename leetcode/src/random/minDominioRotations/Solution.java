package random.minDominioRotations;

class Solution {
  private class ValuePair {
    int total = 0;
    int toTurn = 0;
  }

  private int rotations(int[] tops, int[] bottoms) {
    int min = Integer.MAX_VALUE;
    ValuePair[] count = new ValuePair[6 + 1];
    for (int i = 1; i <= 6; i++) {
      count[i] = new ValuePair();
    }
    for (int i = 0; i < tops.length; i++) {
      count[tops[i]].total++;
      if (tops[i] != bottoms[i]) {
        count[bottoms[i]].toTurn++;
      }
    }
    for (int i = 1; i <= 6; i++) {
      ValuePair c = count[i];
      if (c.toTurn + c.total == tops.length) min = Math.min(min, c.toTurn);
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public int minDominoRotations(int[] tops, int[] bottoms) {
    int top = rotations(tops, bottoms);
    int bottom = rotations(bottoms, tops);
    if (top == -1 && bottom == -1) return -1;
    if (top != -1 && bottom != -1) return Math.min(top, bottom);
    if (top != -1) return top;
    return bottom;
  }
}
