package medium;


public class AddTwoNumbers {
  private class ListNode {
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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode head = null;
    ListNode prev = null;
    while (l1 != null || l2 != null || carry != 0) {
      ListNode current = new ListNode(carry);
      if (head == null) head = current;
      if (prev != null) prev.next = current;
      prev = current;
      if (l1 != null) {
        current.val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        current.val += l2.val;
        l2 = l2.next;
      }
      if (current.val >= 10) {
        current.val %= 10;
        carry = 1;
      } else {
        carry = 0;
      }
    }
    return head;
  }
}
