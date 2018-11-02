package ProblemSolving.Arrays;

import java.util.HashMap;

public class SparseArrays {
  static int[] matchingStrings(String[] strings, String[] queries) {
    HashMap<String, Integer> dic = new HashMap<>();
    for(String s: strings) {
      dic.put(s, dic.getOrDefault(s, 0) + 1);
    }
    int[] ret = new int[queries.length];
    for(int i = 0; i < queries.length; i++){
      String s = queries[i];
      ret[i] = dic.getOrDefault(s, 0);
    }
    return ret;
  }
}
