package Month30Challenge.FirstWeek;

public class CountingElements {
  public int countElements(int[] arr) {
    int count[] = new int[1000 + 5];
    for (int c : arr) count[c]++;
    int total = 0;
    for (int i = 0; i <= 1000; i++) {
      if (count[i] != 0 && count[i + 1] != 0) {
        total += count[i];
      }
    }
    return total;
  }
}
