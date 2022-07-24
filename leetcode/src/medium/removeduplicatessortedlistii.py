
from typing import Optional
# Definition for singly-linked list.


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        c = head
        newHead = head
        prev = None
        while c is not None:
            p = c.next
            while p is not None and c.val == p.val:
                p = p.next
            if p != c.next:
                if prev != None:
                    prev.next = p
                if newHead == c:
                    newHead = p
                c = p
            else:
                prev = c
                c = c.next
        return newHead
            
            
                