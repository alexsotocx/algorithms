package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKLargestTest {

  @Test
  void findKthLargest() {
    FindKLargest findKLargest = new FindKLargest();
    int[] x = new int[]{3,2,1,5,6,4};
    assertEquals(findKLargest.findKthLargest(x, 2), 5);
    x = new int[]{3,2,3,1,2,4,5,5,6};
    assertEquals(findKLargest.findKthLargest(x, 4), 4);
  }
}
