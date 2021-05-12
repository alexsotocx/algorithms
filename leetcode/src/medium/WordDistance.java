package medium;

import java.util.ArrayList;
import java.util.HashMap;

class WordDistance {
  HashMap<String, ArrayList<Integer>> map;

  public WordDistance(String[] wordsDict) {
    map = new HashMap<>();
    for (int i = 0; i < wordsDict.length; i++) {
      final String word = wordsDict[i];
      final int pos = i;
      map.compute(word, (key, val) -> {
        ArrayList<Integer> positions = val;
        if (positions == null) positions = new ArrayList<>();
        positions.add(pos);
        return positions;
      });
    }
  }

  public int shortest(String word1, String word2) {
    ArrayList<Integer> positionWord1 = map.get(word1);
    ArrayList<Integer> positionWord2 = map.get(word2);
    int minDistance = Math.abs(positionWord1.get(0) - positionWord2.get(0));
    for (int pos : positionWord1) {
      int closest = findClosest(positionWord2, pos);
      minDistance = Math.min(minDistance, closest);
    }
    return minDistance;
  }

  private int findClosest(ArrayList<Integer> x, int value) {
    int hi = x.size() - 1;
    int lo = 0;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int midPos = x.get(mid);
      if (midPos > value) hi = mid - 1;
      else lo = mid + 1;
    }
    int closest = Integer.MAX_VALUE;

    if (hi >= 0 && hi < x.size()) closest = Math.min(closest, Math.abs(x.get(hi) - value));
    if (lo >= 0 && lo < x.size()) closest = Math.min(closest, Math.abs(x.get(lo) - value));
    return closest;
  }
}
