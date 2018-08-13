package chapter8;

import java.util.HashSet;

public class E8_9 {
  private HashSet<String>[] memo;

  public E8_9() {
    this.memo = new HashSet[2000];
    memo[0] = new HashSet<>();
    memo[0].add("");
  }

  public HashSet<String> generate(int n) {
    if (memo[n] != null) return memo[n];
    HashSet<String> validP = new HashSet<>();
    for (String s : generate(n - 1)) {
      validP.add("()" + s);
      validP.add(s + "()");
      validP.add("(" + s + ")");
    }
    return validP;
  }

}
