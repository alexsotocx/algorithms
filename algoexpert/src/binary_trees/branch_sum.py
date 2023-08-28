# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def branchSumsHelper(root: BinaryTree, res: list, current_sum):
    if root is None:
        return

    if root.left is None and root.right is None:
        res.append(current_sum + root.value)
        return

    branchSumsHelper(root.left, res, current_sum + root.value)
    branchSumsHelper(root.right, res, current_sum + root.value)

def branchSums(root):
    response = []
    branchSumsHelper(root=root, res=response, current_sum=0)
    return response
