package google;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class EvenOddJumperTest {

  @Test
  void oddEvenJumps() {
    assertEquals(2, new EvenOddJumper().oddEvenJumps(new int[]{10,13,12,14,15}));
    assertEquals(3, new EvenOddJumper().oddEvenJumps(new int[]{2,3,1,1,4}));
    assertEquals(3, new EvenOddJumper().oddEvenJumps(new int[]{5,1,3,4,2}));
  }
}
