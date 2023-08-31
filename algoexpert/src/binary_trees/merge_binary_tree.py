# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def nullize(tree: BinaryTree):
    if tree is None:
        return 0
    return tree.value

def mergeBinaryTrees(tree1: BinaryTree, tree2: BinaryTree):
    if tree1 is None and tree2 is None:
        return None
    node = BinaryTree(nullize(tree1) + nullize(tree2))
    node.left = mergeBinaryTrees(tree1.left if tree1 is not None else None, tree2.left if tree2 is not None else None)
    node.right = mergeBinaryTrees(tree1.right if tree1 is not None else None, tree2.right if tree2 is not None else None)
    return node
