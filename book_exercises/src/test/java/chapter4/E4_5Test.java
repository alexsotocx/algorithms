package chapter4;

import org.junit.Assert;
import org.junit.Test;

public class E4_5Test {

  @Test
  public void isBST() {
    Assert.assertTrue(new E4_5().isBST(new E4_2().convertToTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
    Assert.assertFalse(new E4_5().isBST(new E4_2().convertToTree(new int[]{1, 2, 9, 4, 5, 6, 7, 8, 9, 10})));
  }
}