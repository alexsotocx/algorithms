package datastructures;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

  @org.junit.jupiter.api.Test
  void add() {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.add(10);
    binarySearchTree.add(5);
    binarySearchTree.add(20);
    binarySearchTree.add(12);
    binarySearchTree.add(7);
    binarySearchTree.add(4);
    int[] x = new int[]{4, 5, 7, 10, 12, 20};
    ArrayList<Integer> arrayList = binarySearchTree.nodes();

    for (int i = 0; i < x.length; i++) assertEquals(x[i], arrayList.get(i).intValue());

    assertTrue(binarySearchTree.hasKey(10));
    assertFalse(binarySearchTree.hasKey(8));
    assertTrue(binarySearchTree.hasKey(4));

    binarySearchTree.remove(4);
    x = new int[]{5, 7, 10, 12, 20};
    arrayList = binarySearchTree.nodes();
    for (int i = 0; i < x.length; i++) assertEquals(x[i], arrayList.get(i).intValue());
    assertFalse(binarySearchTree.hasKey(4));

    binarySearchTree.remove(20);
    arrayList = binarySearchTree.nodes();
    System.out.println(arrayList);
    x = new int[]{5, 7, 10, 12};

    for (int i = 0; i < x.length; i++) assertEquals(x[i], arrayList.get(i).intValue());
    assertFalse(binarySearchTree.hasKey(20));
  }
}
