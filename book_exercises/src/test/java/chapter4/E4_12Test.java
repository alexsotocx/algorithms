package chapter4;

import datastructures.BinaryNode;
import org.junit.Assert;
import org.junit.Test;

public class E4_12Test {

  @Test
  public void sumPath() {
    BinaryNode<Integer> root = new BinaryNode<>(1,
      new BinaryNode<Integer>(2,
        new BinaryNode<Integer>(3),
        new BinaryNode(4, null,
          new BinaryNode(-2, new BinaryNode(2), new BinaryNode(0)))),
      new BinaryNode(5, new BinaryNode(2),
        new BinaryNode(3, null, new BinaryNode(-1, null, new BinaryNode(-2))))
    );

    Assert.assertEquals(6, new E4_12().sumPath(6, root));
  }
}
