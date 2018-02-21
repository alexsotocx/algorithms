public class PayBill {

  public int[] whoPaid(int[] meals, int totalMoney) {
    long[] lastPost = new long[500001];
    lastPost[0] = 0;
    for (int i = 0; i < meals.length; i++) {
      for (int j = totalMoney; j >= meals[i]; j--) {
        int value = j - meals[i];
        if (value == 0 || lastPost[value] != 0) {
          lastPost[j] |= (lastPost[value] | (1l<<i));
        }
      }
    }
    long last = lastPost[totalMoney];
    int[] x = new int[Long.bitCount(last)];
    for(int i = 0, j=0; i<meals.length; i++) {
      if((last & (1l<<i)) != 0)
        x[j++] = i;
    }

    return x;
  }

}
