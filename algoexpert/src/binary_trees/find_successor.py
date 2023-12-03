# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent

nodeList = []

nodePosition = None
    
def traverse(tree: BinaryTree, node: BinaryTree):
    global nodeList, nodePosition
    if tree is None:
        return
    traverse(tree.left, node)
    nodeList.append(tree)
    if node == tree:
        nodePosition = len(nodeList) - 1
    traverse(tree.right, node)

def findSuccessor(tree: BinaryTree, node: BinaryTree):
    traverse(tree, node)
    return None if (nodePosition == len(nodeList) - 1) else nodeList[nodePosition + 1]
