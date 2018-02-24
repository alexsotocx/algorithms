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
  }

  @Test
  public void isEmpty() {
  }
}