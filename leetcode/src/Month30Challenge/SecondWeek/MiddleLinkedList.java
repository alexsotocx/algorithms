package Month30Challenge.SecondWeek;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class MiddleLinkedList {
  public ListNode middleNode(ListNode head) {
    ListNode p1 = head;
    ListNode p2 = head;
    while (p2 != null) {
      p2 = p2.next;
      if (p2 == null) break;
      p2 = p2.next;
      p1 = p1.next;
    }
    return p1;
  }
}
