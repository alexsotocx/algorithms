package chapter4;

import datastructures.BinaryNode;
import org.junit.Assert;
import org.junit.Test;

public class E4_8Test {

  @Test
  public void findCommonAncestor() {
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

    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2rright, root), root);
    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2lleft, root), l1Left);
    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2lright, root), l2lright);
  }
}
