from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        if head == None or head.next == None:
            return head
        greater_than_head = None
        greater_than = None
        less_than_head = None
        less_than = None
        t1 = head

        while t1 != None:
            if t1.val < x:
                if less_than == None:
                    less_than_head = t1
                    less_than = t1
                else:
                    less_than.next = t1
                    less_than = less_than.next
            if t1.val >= x:
                if greater_than == None:
                    greater_than_head = t1
                    greater_than = t1
                else:
                    greater_than.next = t1
                    greater_than = greater_than.next
            t2 = t1.next
            t1.next = None
            t1 = t2
        
        if less_than != None:
            less_than.next = greater_than_head
            return less_than_head
        return greater_than_head


        
