package datastructures;

import org.junit.Assert;
import org.junit.Test;


public class HeapTest {
  @Test
  public void Test() {
    Heap<Integer> heap = new Heap<>();
    heap.push(5);
    heap.push(10);
    heap.push(2);
    heap.push(11);
    Assert.assertEquals(Integer.valueOf(11), heap.pop());
    Assert.assertEquals(Integer.valueOf(10), heap.pop());
    Assert.assertEquals(Integer.valueOf(5), heap.pop());
    Assert.assertEquals(Integer.valueOf(2), heap.pop());
  }

}
