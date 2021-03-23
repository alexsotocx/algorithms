package chapter2;

import datastructures.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class E2_6Test {

  @Test
  public void isPalindrome() {
    LinkedListNode first = new LinkedListNode(1,
      new LinkedListNode(2,
        new LinkedListNode(3,
          new LinkedListNode(2, new LinkedListNode(1))
        )
      )
    );

    Assert.assertTrue(new E2_6().isPalindrome(first));

    first = new LinkedListNode(1,
      new LinkedListNode(2,
        new LinkedListNode(3,
          new LinkedListNode(3, new LinkedListNode(2, new LinkedListNode(1)))
        )
      )
    );

    Assert.assertTrue(new E2_6().isPalindrome(first));

    first = new LinkedListNode(1);
    Assert.assertTrue(new E2_6().isPalindrome(first));
    Assert.assertTrue(new E2_6().isPalindrome(null));

    first = new LinkedListNode(1, new LinkedListNode(1));
    Assert.assertTrue(new E2_6().isPalindrome(first));

    first = new LinkedListNode(1, new LinkedListNode(2));
    Assert.assertFalse(new E2_6().isPalindrome(first));

    first = new LinkedListNode(1,
      new LinkedListNode(2,
        new LinkedListNode(3,
          new LinkedListNode(4, new LinkedListNode(2, new LinkedListNode(1)))
        )
      )
    );

    Assert.assertFalse(new E2_6().isPalindrome(first));

    first = new LinkedListNode(1,
      new LinkedListNode(3,
        new LinkedListNode(3,
          new LinkedListNode(2, new LinkedListNode(1))
        )
      )
    );

    Assert.assertFalse(new E2_6().isPalindrome(first));
  }

}
