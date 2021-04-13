package easy;


class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class InvertASingleLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    ListNode t1 = head;
    ListNode t2 = head.next;
    t1.next = null;
    while (t2 != null) {
      ListNode temp = t2.next;
      t2.next = t1;
      t1 = t2;
      t2 = temp;
    }
    return t1;
  }
}
