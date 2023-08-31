# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent

def findSuccessor(tree: BinaryTree, node: BinaryTree):
    if node.right is None:
        p = node
        while p.parent is not None and p.parent.right == p:
            p = p.parent
        return p.parent
    else:
        p = node.right
        while p.left is not None:
            p = p.left
        return p
    

