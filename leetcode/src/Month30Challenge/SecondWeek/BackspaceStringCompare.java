package Month30Challenge.SecondWeek;

public class BackspaceStringCompare {
  public boolean backspaceCompare(String S, String T) {
    return create(S).equals(create(T));
  }

  private String create(String s) {
    StringBuilder sbs = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == '#') {
        if (sbs.length() > 0)
          sbs.deleteCharAt(sbs.length() - 1);
        continue;
      }
      sbs.append(c);
    }
    return sbs.toString();
  }
}
