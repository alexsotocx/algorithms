package chapter4;

import datastructures.BinaryNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class E4_3Test {

  @Test
  public void getLevels() {
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

    ArrayList<LinkedList<BinaryNode<Integer>>> response = new E4_3().getLevels(root);
    Assert.assertEquals(3, response.size());

    int[] level = new int[]{1};
    int i = 0;
    for (BinaryNode<Integer> c : response.get(0)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

    level = new int[]{2, 3};
    i = 0;
    for (BinaryNode<Integer> c : response.get(1)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

    level = new int[]{4, 5, 6, 7};
    i = 0;
    for (BinaryNode<Integer> c : response.get(2)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

  }
}
