# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def invertBinaryTree(tree: BinaryTree):
    if tree is None:
        return
    invertBinaryTree(tree.left)
    invertBinaryTree(tree.right)
    tree.right, tree.left = tree.left, tree.right



