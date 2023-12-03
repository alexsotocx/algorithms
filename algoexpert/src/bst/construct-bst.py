# Do not edit the class below except for
# the insert, contains, and remove methods.
# Feel free to add new properties and methods
# to the class.

def printBST(bst):
    if bst is None:
        return "None"
    return f'[id {bst}, Value {bst.value}, left {bst.left}, right {bst.right}]'
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def isLeaf(self):
        return self.right is None and self.left is None

    def insert(self, value):
        if value < self.value:
            if self.left is None:
                self.left = BST(value)
            else:
                self.left.insert(value)
        else:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)
            
        return self

    def contains(self, value):
        _, pointer = self.findParentAndNode(value)

        print("finding", printBST(pointer))
        return pointer is not None
    
    def findParentAndNode(self, value):
        parent = None
        pointer = self
        while pointer is not None:
            if pointer.value == value:
                return parent, pointer

            parent = pointer
            if value < pointer.value:
                pointer = pointer.left
            else:
                pointer = pointer.right
        return None, None
    
    def findReplacement(self):
        if self.right is None:
            return self, self.left
        
        parent = self
        pointer = self.right
        while pointer.left is not None:
            parent = pointer
            pointer = pointer.left

        return parent, pointer



    def remove(self, value):
        if self.isLeaf():
            return self
        parent, nodeToRemove = self.findParentAndNode(value)

        print(printBST(parent), printBST(nodeToRemove))
        if nodeToRemove is None:
            return self

        if nodeToRemove.isLeaf():
            if parent.right == nodeToRemove:
                parent.right = None
            else:
                parent.left = None

        else:
            replacementParent, replacementNode = nodeToRemove.findReplacement()
            
            nodeToRemove.value = replacementNode.value
            if not replacementNode.isLeaf():
                if replacementParent.left == replacementNode:
                    replacementParent.left = replacementNode.left if replacementNode.left is not None else replacementNode.right
                else:
                    replacementParent.right = replacementNode.right if replacementNode.right is not None else replacementNode.left
            else:
                if replacementParent.left == replacementNode:
                    replacementParent.left = None
                else:
                    replacementParent.right = None

                
            
            
        print("-----------------------------\n",printBST(parent), printBST(nodeToRemove))
        return self
