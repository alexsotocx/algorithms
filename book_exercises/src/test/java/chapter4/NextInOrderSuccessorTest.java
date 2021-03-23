package chapter4;

import datastructures.BinaryNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextInOrderSuccessorTest {

  @Test
  void findNextInOrderSuccessor() {
    BinaryNode<Integer> b5 = new BinaryNode<>(5);
    BinaryNode<Integer> b8 = new BinaryNode<>(8);
    BinaryNode<Integer> b7 = new BinaryNode<>(7, b5, b8);
    b8.parent = b7;
    b5.parent = b7;

    BinaryNode<Integer> b11 = new BinaryNode<>(11);
    BinaryNode<Integer> b10Root = new BinaryNode<>(10, b7, b11);
    b11.parent = b10Root;
    b7.parent = b10Root;
    b10Root.inOrder();
    NextInOrderSuccessor<Integer> x = new NextInOrderSuccessor<>();
    assertEquals(b7, x.findNextInOrderSuccessor(b5));
    assertEquals(b10Root, x.findNextInOrderSuccessor(b8));
    assertEquals(b8, x.findNextInOrderSuccessor(b7));
    assertEquals(b11, x.findNextInOrderSuccessor(b11));
    assertEquals(b11, x.findNextInOrderSuccessor(b10Root));
  }
}
