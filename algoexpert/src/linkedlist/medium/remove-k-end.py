# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def removeKthNodeFromEnd(head: LinkedList, k: int):
    pFast = head
    pSlow = head
    prev = None

    for _ in range(k):
        pFast = pFast.next
    
    while pFast is not None:
        pFast = pFast.next
        prev = pSlow
        pSlow = pSlow.next
    
    if pSlow.next == None:
        prev.next = None
    else:
        pSlow.value = pSlow.next.value
        pSlow.next = pSlow.next.next
    
    