package amazon.NumOfTeams;

import java.util.*;

class Solution {

  public int numTeams(int[] rating) {
    HashMap<Integer, ArrayList<Integer>> moreThan = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> lessThan = new HashMap<>();
    for(int i = 0;i< rating.length; i++) {
      moreThan.put(rating[i], new ArrayList<>());
      lessThan.put(rating[i], new ArrayList<>());
      for(int j = i + 1; j < rating.length; j++) {
        if (rating[i] > rating[j]) {
          moreThan.get(rating[i]).add(rating[j]);
        } else {
          lessThan.get(rating[i]).add(rating[j]);

        }
      }
    }
    int count = 0;
    for (int v: rating) {
      ArrayList<Integer> m = moreThan.get(v);
      if (m.size() <= 1) continue;
      for(int vv: m) {
        count += moreThan.get(vv).size();
      }
    }
    for (int v: rating) {
      ArrayList<Integer> m = lessThan.get(v);
      if (m.size() <= 1) continue;
      for(int vv: m) {
        count += lessThan.get(vv).size();
      }
    }
    return count;
  }
}
