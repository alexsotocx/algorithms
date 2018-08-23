package InterviewPrepartionKit.HashMaps;

public class TwoStrings {
  String twoStrings(String s1, String s2) {
    int[] chars = new int['z' - 'a' + 1];
    for (char c : s1.toCharArray()) chars[c - 'a']++;
    for (char c : s2.toCharArray()) {
      if (chars[c - 'a'] != 0) return "YES";
    }

    return "NO";
  }
}
