# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def nodeDepthsHelper(root: BinaryTree, currentDepth: int):
    if root is None:
        return 0
    return currentDepth + nodeDepthsHelper(root.left, currentDepth + 1) + nodeDepthsHelper(root.right, currentDepth + 1)    
    

def nodeDepths(root: BinaryTree) -> int:
    return nodeDepthsHelper(root, 0)