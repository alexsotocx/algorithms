package chapter4;

import datastructures.BinaryNode;
import org.junit.Test;

public class E4_2Test {

  @Test
  public void convertToTree() {
    BinaryNode<Integer> root = new E4_2().convertToTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    System.out.println(root);
    System.out.println(root);
  }
}
