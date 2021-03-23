package Month30Challenge.SecondWeek;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastStoneWeightTest {

  @Test
  void lastStoneWeight() {
    assertEquals(0, new LastStoneWeight().lastStoneWeight(new int[]{1, 1}));
    assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[]{1}));
    assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
  }
}
