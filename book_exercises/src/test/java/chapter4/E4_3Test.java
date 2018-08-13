package chapter4;

import datastructures.BNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class E4_3Test {

  @Test
  public void getLevels() {
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

    ArrayList<LinkedList<BNode<Integer>>> response = new E4_3().getLevels(root);
    Assert.assertEquals(3, response.size());

    int[] level = new int[]{1};
    int i = 0;
    for (BNode<Integer> c : response.get(0)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

    level = new int[]{2, 3};
    i = 0;
    for (BNode<Integer> c : response.get(1)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

    level = new int[]{4, 5, 6, 7};
    i = 0;
    for (BNode<Integer> c : response.get(2)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

  }
}