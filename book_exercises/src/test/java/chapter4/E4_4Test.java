package chapter4;

import datastructures.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E4_4Test {
  @Test
  public void isBalanced() {
    BinaryNode<Integer> root = new BinaryNode<>(1);
    BinaryNode<Integer> l1Left = new BinaryNode<>(2);
    BinaryNode<Integer> l1right = new BinaryNode<>(3);
    BinaryNode<Integer> l2lleft = new BinaryNode<>(4);
    BinaryNode<Integer> l2lright = new BinaryNode<>(5);
    BinaryNode<Integer> l2rleft = new BinaryNode<>(6);
    BinaryNode<Integer> l2rright = new BinaryNode<>(7);

    root.left = l1Left;
    root.right = l1right;
    l1Left.left = l2lleft;
    l1Left.right = l2lright;
    l1right.left = l2rleft;
    l1right.right = l2rright;

    assertTrue(new E4_4().isBalanced(root));

    root.left = null;
    assertFalse(new E4_4().isBalanced(root));

    root.right = null;
    root.left = null;
    assertTrue(new E4_4().isBalanced(root));

    root.left = l1Left;
    root.right = l1right;
    l1Left.left = null;
    l1Left.right = l2lright;
    l1right.left = l2rleft;
    l1right.right = l2rright;

    assertTrue(new E4_4().isBalanced(root));

    root.left = l1Left;
    root.right = l1right;
    l1Left.left = null;
    l1Left.right = l2lright;
    l1right.left = l2rleft;
    l1right.right = l2rright;
    l2lright.right = l2lleft;

    assertFalse(new E4_4().isBalanced(root));
  }
}
