package Month30Challenge.march.firstweek.countbits;

class Solution {
  public int[] countBits(int n) {
    int[] sol = new int[n + 1];
    sol[0] = 0;
    if (n == 0) return sol;
    sol[1] = 1;
    for(int i = 2; i<=n;i++) {
      sol[i] = sol[i / 2] + ((i % 2 == 0) ? 0 : 1);
    }
    return sol;
  }
}
