package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

  @Test
  public void append() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);
    int testArray[] = {1,2,3};
    DoubleLinkedList.LinkIterator it = (DoubleLinkedList.LinkIterator) linkedList.iterator();
    for(int j : testArray)
      assertEquals(j, it.next().data);
  }

  @Test
  public void prepend() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.prepend(1);
    linkedList.prepend(2);
    linkedList.prepend(3);
    int testArray[] = {3,2,1};
    DoubleLinkedList.LinkIterator it = (DoubleLinkedList.LinkIterator) linkedList.iterator();
    for(int j : testArray)
      assertEquals(j, it.next().data);
  }

  @Test
  public void find() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.prepend(1);
    linkedList.prepend(2);
    linkedList.prepend(3);
    DoubleLinkedList<Integer>.Link<Integer> foundLink = linkedList.find(3);
    assertTrue("It returns the same value", foundLink.data.equals(3));
    assertNull(linkedList.find(5));
  }

  @Test
  public void isEmpty() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    assertTrue("When there are no element it returns true", linkedList.isEmpty());
    linkedList.prepend(1);
    assertFalse("When there are element it returns false", linkedList.isEmpty());
  }
}