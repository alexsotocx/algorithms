package chapter4;

import datastructures.BNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E4_4Test {
  @Test
  public void isBalanced() {
    BNode<Integer> root = new BNode<>(1);
    BNode<Integer> l1Left = new BNode<>(2);
    BNode<Integer> l1right = new BNode<>(3);
    BNode<Integer> l2lleft = new BNode<>(4);
    BNode<Integer> l2lright = new BNode<>(5);
    BNode<Integer> l2rleft = new BNode<>(6);
    BNode<Integer> l2rright = new BNode<>(7);

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