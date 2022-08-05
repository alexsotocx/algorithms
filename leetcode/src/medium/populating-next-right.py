import queue
from typing import List

# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left = None, right = None, next = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root):
        if root is None:
            return root
        q = queue.SimpleQueue()
        q.put((root, 0))
        levelNodes = []
        current_level = 0
        while not q.empty():
            c, l = q.get_nowait()
            if current_level != l:
                current_level = l
                for i in range(1, len(levelNodes)):
                    levelNodes[i - 1].next = levelNodes[i]
                levelNodes = []
            if c.left is not None:
                levelNodes.append(c.left)
                q.put((c.left, l + 1))
            if c.right is not None:
                levelNodes.append(c.right)
                q.put((c.right, l + 1))

        for i in range(1, len(levelNodes)):
            levelNodes[i - 1].next = levelNodes[i]
        return root
