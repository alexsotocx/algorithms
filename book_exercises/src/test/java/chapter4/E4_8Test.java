package chapter4;

import datastructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

public class E4_8Test {

  @Test
  public void findCommonAncestor() {
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

    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2rright, root), root);
    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2lleft, root), l1Left);
    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2lright, root), l2lright);
  }
}