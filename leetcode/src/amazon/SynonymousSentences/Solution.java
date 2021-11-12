package amazon.SynonymousSentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

class Solution {
  private ArrayList<String> res;
  private HashMap<String, TreeSet<String>> mapper;

  private void replace(String[] w, int i, String[] currentBuild) {
    if (i == w.length) {
      StringBuilder s = new StringBuilder();

      res.add(String.join(" ", currentBuild));
      return;
    }

    String c = w[i];

    if (mapper.containsKey(c)) {
      for (String s : mapper.get(c)) {
        currentBuild[i] = s;
        replace(w, i + 1, currentBuild);
      }
    } else {
      currentBuild[i] = c;
      replace(w, i + 1, currentBuild);
    }
  }

  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    mapper = new HashMap<>();
    for (List<String> s : synonyms) {
      final String a = s.get(0);
      final String b = s.get(1);
      TreeSet<String> setA = mapper.get(a);
      TreeSet<String> setB = mapper.get(b);
      TreeSet<String> set;
      if (setA != null && setB != null) {
        set = setA;
        for (String ss : setB) {
          setA.add(ss);
          mapper.put(ss, setA);
        }
      } else if (setA != null) {
        set = setA;
      } else if (setB != null) {
        set = setB;
      } else {
        set = new TreeSet<>();
      }
      set.add(b);
      set.add(a);
      mapper.put(b, set);
      mapper.put(a, set);
    }

    res = new ArrayList<>();
    String[] splitted = text.split(" +");
    this.replace(splitted, 0, new String[splitted.length]);

    return res;
  }
}
