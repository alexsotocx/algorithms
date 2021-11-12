package amazon.SynonymousSentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

class Solution {
  private ArrayList<String> res;
  private HashMap<String, TreeSet<String>> mapper;

  private void replace(String[] w, int i, ArrayList<String> currentBuild) {
    if (i == w.length) {
      StringBuilder s = new StringBuilder();

      res.add(String.join(" ", currentBuild));
      return;
    }

    String c = w[i];

    if (mapper.containsKey(c)) {
      for (String s : mapper.get(c)) {
        currentBuild.add(s);
        replace(w, i + 1, currentBuild);
        currentBuild.remove(currentBuild.size() - 1);
      }
    } else {
      currentBuild.add(c);
      replace(w, i + 1, currentBuild);
      currentBuild.remove(currentBuild.size() - 1);
    }
  }

  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    mapper = new HashMap<>();
    for (List<String> s : synonyms) {
      final String a = s.get(0);
      final String b = s.get(1);
      TreeSet<String> setA = mapper.get(a);
      TreeSet<String> setB = mapper.get(b);
      TreeSet<String> set = new TreeSet<>();
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
      }
      set.add(b);
      set.add(a);
      mapper.put(b, set);
      mapper.put(a, set);
    }

    res = new ArrayList<>();
    this.replace(text.split(" +"), 0, new ArrayList<>());

    return res;
  }
}
