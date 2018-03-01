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
    assertFullList(linkedList, new int[]{1, 2, 3});
  }

  @Test
  public void prepend() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.prepend(1);
    linkedList.prepend(2);
    linkedList.prepend(3);
    assertFullList(linkedList, new int[]{3, 2, 1});
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

  @Test
  public void deleteFirstElement() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);

    assertTrue("Returns the first element", linkedList.delete(linkedList.getFirst()).data.equals(1));
    assertFullList(linkedList, new int[]{2, 3});
  }

  @Test
  public void deleteLastElement() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);

    assertTrue("Returns the last element", linkedList.delete(linkedList.getLast()).data.equals(3));
    assertFullList(linkedList, new int[]{1, 2});
  }

  @Test
  public void deleteMiddleElement() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    DoubleLinkedList<Integer>.Link<Integer> link = linkedList.append(2);
    linkedList.append(3);

    assertTrue("Returns the last element", linkedList.delete(link).data.equals(2));
    assertFullList(linkedList, new int[]{1, 3});
  }

  @Test
  public void insertAfterLast() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(2);
    DoubleLinkedList<Integer>.Link<Integer> link = linkedList.append(3);

    linkedList.insertAfter(link, 4);

    assertFullList(linkedList, new int[]{1, 2, 3, 4});
  }

  @Test
  public void insertAfterMiddle() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    DoubleLinkedList<Integer>.Link<Integer> link = linkedList.append(2);
    linkedList.append(3);

    linkedList.insertAfter(link, 4);

    assertFullList(linkedList, new int[]{1, 2, 4, 3});
  }

  @Test
  public void insertBeforeFirst() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    DoubleLinkedList<Integer>.Link<Integer> link = linkedList.append(1);
    linkedList.append(2);
    linkedList.append(3);

    linkedList.inserBefore(link, 4);

    assertFullList(linkedList, new int[]{4, 1, 2, 3});
  }

  @Test
  public void insertBeforeAtMiddle() {
    DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
    linkedList.append(1);
    linkedList.append(2);
    DoubleLinkedList<Integer>.Link<Integer> link = linkedList.append(3);

    linkedList.inserBefore(link, 4);

    assertFullList(linkedList, new int[]{1, 2, 4, 3});
  }


  private void assertFullList(DoubleLinkedList<Integer> doubleLinkedList, int[] toCompare) {
    DoubleLinkedList.LinkIterator it = (DoubleLinkedList.LinkIterator) doubleLinkedList.iterator();
    DoubleLinkedList.LinkIterator rit = (DoubleLinkedList.LinkIterator) doubleLinkedList.reversedIterator();
    for (int i = 0, j = toCompare.length - 1; i < toCompare.length; i++, j--) {
      assertEquals(toCompare[i], it.next().data);
      assertEquals(toCompare[j], rit.next().data);
    }
    assertFalse("It has no more elements to loop", it.hasNext());
    assertFalse("It has no more elements to loop", rit.hasNext());
  }
}