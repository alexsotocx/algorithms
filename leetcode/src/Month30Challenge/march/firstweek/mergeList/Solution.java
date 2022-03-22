package Month30Challenge.march.firstweek.mergeList;

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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode l1p = list1;
    ListNode l2p = list2;
    ListNode head;

    if (l1p.val < l2p.val) {
      head = l1p;
      l1p = l1p.next;
    } else {
      head = l2p;
      l2p = l2p.next;
    }
    ListNode p = head;


    while (l1p != null) {
      if (l2p == null || l1p.val < l2p.val ) {
        p.next = l1p;
        l1p = l1p.next;
      } else {
        p.next = l2p;
        l2p = l2p.next;
      }
      p = p.next;
    }

    while(l2p != null) {
      p.next = l2p;
      l2p = l2p.next;
      p = p.next;
    }

    return head;

  }
}
