package amazon.arrayRank;

import java.util.HashMap;
import java.util.TreeSet;

class Solution {
  public int[] arrayRankTransform(int[] arr) {
    TreeSet<Integer> set = new TreeSet<Integer>();
    HashMap<Integer, Integer> x = new HashMap<>();
    for (int a : arr) set.add(a);
    int i = 1;
    for (int a : set) x.put(a, i++);
    int[] res = new int[arr.length];
    for (i = 0; i < arr.length; i++) {
      res[i] = x.get(arr[i]);
    }
    return res;
  }
}
