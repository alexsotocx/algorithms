package chapter4;

import datastructures.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E4_4Test {
  @Test
  public void isBalanced() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
    BinaryTreeNode<Integer> l1Left = new BinaryTreeNode<>(2);
    BinaryTreeNode<Integer> l1right = new BinaryTreeNode<>(3);
    BinaryTreeNode<Integer> l2lleft = new BinaryTreeNode<>(4);
    BinaryTreeNode<Integer> l2lright = new BinaryTreeNode<>(5);
    BinaryTreeNode<Integer> l2rleft = new BinaryTreeNode<>(6);
    BinaryTreeNode<Integer> l2rright = new BinaryTreeNode<>(7);

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