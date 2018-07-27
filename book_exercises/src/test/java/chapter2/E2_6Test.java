package chapter2;

import datastructures.LNode;
import org.junit.Assert;
import org.junit.Test;

public class E2_6Test {

  @Test
  public void isPalindrome() {
    LNode first = new LNode(1,
        new LNode(2,
            new LNode(3,
                new LNode(2, new LNode(1))
            )
        )
    );

    Assert.assertTrue(new E2_6().isPalindrome(first));

    first = new LNode(1,
        new LNode(2,
            new LNode(3,
                new LNode(3, new LNode(2, new LNode(1)))
            )
        )
    );

    Assert.assertTrue(new E2_6().isPalindrome(first));

    first = new LNode(1);
    Assert.assertTrue(new E2_6().isPalindrome(first));
    Assert.assertTrue(new E2_6().isPalindrome(null));

    first = new LNode(1, new LNode(1));
    Assert.assertTrue(new E2_6().isPalindrome(first));

    first = new LNode(1, new LNode(2));
    Assert.assertFalse(new E2_6().isPalindrome(first));

    first = new LNode(1,
        new LNode(2,
            new LNode(3,
                new LNode(4, new LNode(2, new LNode(1)))
            )
        )
    );

    Assert.assertFalse(new E2_6().isPalindrome(first));

    first = new LNode(1,
        new LNode(3,
            new LNode(3,
                new LNode(2, new LNode(1))
            )
        )
    );

    Assert.assertFalse(new E2_6().isPalindrome(first));
  }

}