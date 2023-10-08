# This is an input class. Do not edit.
class LinkedList:
  def __init__(self, value):
    self.value = value
    self.next = None


def findLoop(head: LinkedList):
  slow = head
  fast = head

  # Move the pointers until they meet
  while True:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
      break


  # Move one pointer to the head and keep the other at the meeting point
  slow = head
  while slow != fast:
    slow = slow.next
    fast = fast.next

  # Return the node at the beginning of the loop
  return slow
