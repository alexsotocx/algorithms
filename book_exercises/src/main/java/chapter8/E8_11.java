package chapter8;

import java.util.Arrays;

public class E8_11 {
  private long[][] memo;
  private int[] coins;
  private final int MAX = 10000;

  public E8_11(int... coins) {
    this.coins = coins;
    memo = new long[coins.length][MAX];
    for (int i = 0; i < coins.length; i++) Arrays.fill(memo[i], -1);
  }

  public long change(int v) {
    if (v == 0) return 0;
    return change(v, 0);
  }

  private long change(int v, int type) {
    if (v < 0 || type >= coins.length) return 0;
    if (v == 0) return 1;
    if (memo[type][v] != -1) return memo[type][v];
    return memo[type][v] = change(v, type + 1) + change(v - coins[type], type);
  }
}
