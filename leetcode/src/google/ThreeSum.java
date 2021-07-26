package google;

import java.util.*;

public class ThreeSum {
  class Pair  {
    int i,j, x, y;

    public Pair(int i, int j, int x, int y) {
      this.i = i;
      this.j = j;
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    boolean isAfter(int k) {
      return i < k && j < k;
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    HashMap<Integer, HashSet<Pair>> sums = new HashMap<>();
    HashSet<List<Integer>> answer = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        int total = nums[i] + nums[j];
        int finalJ = j;
        int finalI = i;
        sums.compute(total, (integer, pairs) -> {
          if (pairs == null) pairs = new HashSet<>();
          pairs.add(new Pair(finalI, finalJ, nums[finalI], nums[finalJ]));
          return pairs;
        });
      }
    }
    for (int i = 0; i < nums.length; i++) {
      int v = nums[i];
      int toFind = -v;
      if (sums.containsKey(toFind)) {
        for (Pair p: sums.get(toFind)) {
          if (p.isAfter(i)) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(nums[p.i]);
            res.add(nums[p.j]);
            res.add(nums[i]);
            answer.add(res);

          }
        }
      }
    }
    return new ArrayList<>(answer);
  }
}
