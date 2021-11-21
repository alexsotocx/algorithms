package amazon.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  private int[] countChars(String str) {
    int[] res = new int[26];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      res[c - 'a']++;
    }
    return res;
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Integer, ArrayList<String>> map = new HashMap<>();
    for (String s : strs) {
      int[] count = countChars(s);
      int code = Arrays.hashCode(count);
      ArrayList<String> arr = map.computeIfAbsent(code, integer -> new ArrayList<>());
      arr.add(s);
    }
    List<List<String>> res = new ArrayList<>(map.values());
    return res;
  }
}
