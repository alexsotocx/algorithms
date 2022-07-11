package random.ZizagConversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void convert() {
    assertEquals("PAHNAPLSIIGYIR", new Solution().convert("PAYPALISHIRING", 3));
  }
}
