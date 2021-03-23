package Month30Challenge.FirstWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupingAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Integer, Integer> positionMap = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    for (String str : strs) {
      int[] count = countString(str.toCharArray());
      int hashCode = Arrays.hashCode(count);
      int position = positionMap.getOrDefault(hashCode, result.size());
      if (!positionMap.containsKey(hashCode)) {
        positionMap.put(hashCode, position);
        result.add(new ArrayList<>());
      }
      result.get(position).add(str);
    }
    return result;
  }

  private int[] countString(char[] word) {
    int size = 'z' - 'a';
    int[] chars = new int[size + 1];
    for (char c : word) chars[c - 'a']++;
    return chars;
  }
}
