# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSubtreeUtil(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None and subRoot is None:
            return True
        if None in [root, subRoot]:
            return False
        return root.val == subRoot.val and self.isSubtreeUtil(root.left, subRoot.left) and self.isSubtreeUtil(root.right, subRoot.right)
            
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None and subRoot is None:
            return True
        if None in [root, subRoot]:
            return False
        
        return self.isSubtreeUtil(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot) 
