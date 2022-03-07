package Month30Challenge.march.firstweek.issubsequence;

import java.util.ArrayList;

class Solution {
  int lowerBound(ArrayList<Integer> t, int k) {
    int low = 0;
    int hi = t.size() - 1;
    int closest = t.size();
    int mid = 0;
    while (low <= hi) {
      mid = low + (hi - low) /2;
      if (t.get(mid) <= k) {
        low = mid + 1;
      } else {
        if (closest > mid) closest = mid;
        hi = mid - 1;
      }
    }
    return closest;
  }
  public boolean isSubsequence(String s, String t) {
    ArrayList<Integer>[] table = new ArrayList[26];
    for (int i = 0 ; i < t.length(); i++) {
      int c = t.charAt(i) - 'a';
      if (table[c] == null) table[c] = new ArrayList<>();
      table[c].add(i);
    }

    int last = -1;
    for (int i = 0 ; i < s.length(); i++) {
      int c = s.charAt(i) - 'a';

      if (table[c] == null) return false;
      int nextPos = lowerBound(table[c], last);
      if (nextPos == table[c].size()) {
        return false;
      }
      last = table[c].get(nextPos);
    }
    return true;
  }
}
