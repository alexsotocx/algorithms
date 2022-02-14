package explore.dp.tribonnaci;

class Solution {
  public int tribonacci(int n) {
    int[] t = new int[]{0, 1, 1};
    if (n < 3) return t[n];
    for(int i = 3; i <= n; i++) {
      int temp = t[2] + t[1] + t[0];
      t[0] = t[1] ;
      t[1] = t[2];
      t[2] = temp;
    }
    return t[2];
  }
}
