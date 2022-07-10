package random.onezeros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void findMaxForm() {
    assertEquals(4, new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
  }
}
