package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

  @Test
  public void insert() {
    Queue<Integer> queue =  new Queue<>();
    queue.insert(1);
    queue.insert(2);
    queue.insert(3);
    assertQueue(queue, new int[] {1, 2, 3});
  }

  @Test
  public void first() {
    Queue<Integer> queue =  new Queue<>();
    queue.insert(1);

    assertEquals(queue.first().longValue(), 1);
    assertFalse("Queue must not be empty", queue.isEmpty());
  }

  @Test
  public void removeFirst() {
    Queue<Integer> queue =  new Queue<>();
    queue.insert(1);

    assertEquals(queue.removeFirst().longValue(), 1);
    assertTrue("Queue must be empty", queue.isEmpty());
  }

  @Test
  public void isEmpty() {
    Queue<Integer> queue =  new Queue<>();
    assertTrue("Queue must be empty", queue.isEmpty());
  }

  private void assertQueue(Queue<Integer> q, int[] expected) {
    for(int data : expected)
      assertEquals(q.removeFirst().longValue(), data);
    assertTrue("Queue is empty after loops", q.isEmpty());
  }
}