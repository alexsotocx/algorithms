package chapter4;

import datastructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class E4_3Test {

  @Test
  public void getLevels() {
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

    ArrayList<LinkedList<BinaryTreeNode<Integer>>> response = new E4_3().getLevels(root);
    Assert.assertEquals(3, response.size());

    int[] level = new int[]{1};
    int i = 0;
    for (BinaryTreeNode<Integer> c : response.get(0)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

    level = new int[]{2, 3};
    i = 0;
    for (BinaryTreeNode<Integer> c : response.get(1)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

    level = new int[]{4, 5, 6, 7};
    i = 0;
    for (BinaryTreeNode<Integer> c : response.get(2)) {
      Assert.assertEquals(level[i++], c.data.intValue());
    }

  }
}