package amazon.SortArrayByRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int inf = Integer.MAX_VALUE;
    IntStream.range(0, arr2.length).forEach(i -> map.put(arr2[i], i));
    ArrayList<Integer> x = (ArrayList<Integer>) IntStream.of(arr2).boxed().collect(Collectors.toList());
    x.sort((a, b) -> {
      int xa = map.getOrDefault(a, inf);
      int xb = map.getOrDefault(b, inf);
      if (xa != xb) return Integer.compare(xa, xb);
      return Integer.compare(a, b);
    });

    return x.stream().mapToInt(i -> i).toArray();
  }
}
