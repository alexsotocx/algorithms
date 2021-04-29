import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetProbabilityOfGettingCatchTest {

  @Test
  void probabilityOfNotGettingCaught() {
    int[] path = new int[]{0, 1, 5, 6};
    GetProbabilityOfGettingCatch x = new GetProbabilityOfGettingCatch(4, 4);
    assertEquals(0.1 * 0.55 * 0.55, x.findProbabilityOfNotGettingCatch(path), Math.pow(10, -6));
    path = new int[]{0, 1, 5, 6, 10, 9};
    assertEquals(0.1 * 0.55 * 0.55 * 0.775 * 0.775, x.findProbabilityOfNotGettingCatch(path), Math.pow(10, -6));
  }
}
