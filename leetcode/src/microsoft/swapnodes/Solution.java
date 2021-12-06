package microsoft.swapnodes;

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

class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode p1 = head;
    head = p1.next;
    while (p1 != null && p1.next != null) {
      ListNode p2 = p1.next;
      ListNode tmp = p2.next;
      p2.next = p1;
      if (tmp != null && tmp.next != null) p1.next = tmp.next;
      else p1.next = tmp;
      p1 = tmp;
    }

    return head;
  }
}

