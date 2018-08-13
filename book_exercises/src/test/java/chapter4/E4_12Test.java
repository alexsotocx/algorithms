package chapter4;

import datastructures.BNode;
import org.junit.Assert;
import org.junit.Test;

public class E4_12Test {

  @Test
  public void sumPath() {
    BNode<Integer> root = new BNode<>(1,
        new BNode<Integer>(2,
            new BNode<Integer>(3),
            new BNode(4, null,
                new BNode(-2, new BNode(2), new BNode(0)))),
        new BNode(5, new BNode(2),
            new BNode(3, null, new BNode(-1, null, new BNode(-2))))
    );

    Assert.assertEquals(6, new E4_12().sumPath(6, root));
  }
}