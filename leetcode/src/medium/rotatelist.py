# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or k == 0:
            return head
        length = 0
        tail = None
        newHead = head
        while (newHead is not None):
            if (newHead.next is None):
                tail = newHead
            newHead = newHead.next
            length += 1

        it = length - (k % length)
        if (tail == head or it == 0):
            return head
        
        tail.next = head
        newHead = head
        prev = None

        for _ in range(it):
            prev = newHead
            newHead = newHead.next
        prev.next = None
        return newHead

Solution().rotateRight(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2)
# Solution().rotateRight(ListNode(1, ListNode(2)),1)