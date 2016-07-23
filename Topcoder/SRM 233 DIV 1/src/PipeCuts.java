import java.util.Arrays;

public class PipeCuts {

  public double probability(int[] weldLocations, int L) {
    Arrays.sort(weldLocations);
    int posible = 0;
    int valid = 0;
    for (int i = 0; i < weldLocations.length - 1; i++) {
      for (int j = i + 1; j < weldLocations.length; j++) {
        posible++;
        if (weldLocations[i] > L || weldLocations[j] - weldLocations[i] > L || 100 - weldLocations[j] > L) {
          valid++;
        }
      }
    }
    return (valid * 1.0) / posible;
  }
}
