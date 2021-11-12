package amazon.arrayRank;


import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int[] cp = Arrays.copyOf(arr, arr.length);
    Arrays.sort(cp);
    HashMap<Integer, Integer> x = new HashMap<>();
    int i = 1;
    for (int a : cp) {
      if (!x.containsKey(a)) x.put(a, i++);
    }
    int[] res = new int[arr.length];
    for (i = 0; i < arr.length; i++) {
      res[i] = x.get(arr[i]);
    }
    return res;
  }
}
