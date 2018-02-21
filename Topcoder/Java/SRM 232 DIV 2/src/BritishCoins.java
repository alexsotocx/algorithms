
public class BritishCoins {

  public int[] coins(int pence) {
    int pounds = pence / (12 * 20);
    pence -= pounds * (12 * 20);
    int shillings = pence / 12;
    pence -= shillings * 12;
    return new int[]{pounds, shillings, pence};
  }
}
