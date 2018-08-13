package chapter4;

import datastructures.BNode;
import org.junit.Assert;
import org.junit.Test;

public class E4_8Test {

  @Test
  public void findCommonAncestor() {
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

    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2rright, root), root);
    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2lleft, root), l1Left);
    Assert.assertEquals(new E4_8().findCommonAncestor(l2lright, l2lright, root), l2lright);
  }
}