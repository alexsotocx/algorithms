package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

  @Test
  void threeSum() {
    System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}
