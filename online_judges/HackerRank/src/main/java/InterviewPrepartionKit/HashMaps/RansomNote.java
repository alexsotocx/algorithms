package InterviewPrepartionKit.HashMaps;

import java.util.HashMap;

public class RansomNote {
  // Complete the checkMagazine function below.
  void checkMagazine(String[] magazine, String[] note) {
    HashMap<String, Integer> s1 = new HashMap<>();
    HashMap<String, Integer> s2 = new HashMap<>();
    for (String s : magazine) s1.put(s, s1.getOrDefault(s, 0) + 1);
    boolean works = true;
    for (String s : note) {
      int c = s1.getOrDefault(s, 0);
      if (c != 0) {
        s1.put(s, c - 1);
      } else {
        works = false;
        break;
      }
    }

    if (works) System.out.println("Yes");
    else System.out.println("No");

  }
}
