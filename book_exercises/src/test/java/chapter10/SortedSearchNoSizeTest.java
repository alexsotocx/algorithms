package chapter10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortedSearchNoSizeTest {

  @Test
  void search() {
    int data[] = new int[]{1, 2, 3, 10, 20, 30, 40, 50};
    SortedSearchNoSize dataStructure = new SortedSearchNoSize(data);
    Assertions.assertEquals(-1, dataStructure.getElementAt(data.length));
    Assertions.assertEquals(50, dataStructure.getElementAt(data.length - 1));
    Assertions.assertEquals(3, dataStructure.search(10));
  }
}
