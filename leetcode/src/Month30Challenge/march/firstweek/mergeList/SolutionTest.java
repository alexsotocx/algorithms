package Month30Challenge.march.firstweek.mergeList;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  @Test
  void mergeTwoLists() {
    ListNode l1 = new ListNode(-9, new ListNode(3));
    ListNode l2 = new ListNode(5, new ListNode(7));
    ListNode l3 = new Solution().mergeTwoLists(l1, l2);


  }
}
