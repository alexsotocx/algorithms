package trees

import "../interfaces"

type BinarySearchTree struct {
  BinaryTree
}

func (n node) isLeaf() bool {
  return n.RightChildren == nil && n.LeftChildren != nil
}

func (tree *BinarySearchTree) Insert(data interfaces.Comparable) {
 tree.size++
 if tree.root == nil {
   tree.root = newNode(data)
 } else {
   parent := tree.root
   for {
     if parent.Data.Compare(data) == 1  {
       if parent.RightChildren == nil {
         parent.RightChildren = newNode(data)
         break
       }
       parent = parent.RightChildren
     } else {
       if parent.LeftChildren == nil {
         parent.LeftChildren = newNode(data)
         break
       }
       parent = parent.LeftChildren
     }
   }
 }
}

func (tree BinarySearchTree) Find(data interfaces.Comparable) (bool, interfaces.Comparable) {
  _, nodeFound := tree.find(data)
  if nodeFound == nil {
    return false, nil
  }
  return true, nodeFound.Data
}

func (tree BinarySearchTree) find(data interfaces.Comparable) (*node, *node) {
  current := tree.root
  var parent *node
  for current != nil {
    valCom := current.Data.Compare(data)
    if valCom == 0 {
      return parent, current
    }
    parent = current
    if valCom == 1 {
      current = current.RightChildren
    } else {
      current = current.LeftChildren
    }
  }
  return nil, nil
}


func (tree *BinarySearchTree) Delete(data interfaces.Comparable) (bool, interfaces.Comparable) {
  parent, toDelete := tree.find(data)
  if toDelete != nil {
    tree.size--
    if toDelete.isLeaf() {
      if toDelete == tree.root {
        tree.root = nil
        return true, data
      }
      if parent.LeftChildren == toDelete {
        parent.LeftChildren = nil
      } else {
        parent.RightChildren = nil
      }
    } else  {
      replacement := tree.findAndReplace(toDelete)
      if toDelete.LeftChildren == nil {
        if parent.RightChildren == toDelete {
          parent.RightChildren = replacement
        } else {
          parent.LeftChildren = replacement
        }
      } else {
        if toDelete.LeftChildren == replacement {
          toDelete.Data = replacement.Data
          toDelete.LeftChildren = replacement.LeftChildren
        } else {
          toDelete.Data = replacement.Data
        }
      }
    }
    return true, data
  }

  return false, nil
}


func (tree BinarySearchTree) findAndReplace(current *node) (*node) {
  if current.LeftChildren != nil {
    parent := current
    current = current.LeftChildren
    for current.RightChildren != nil {
      parent = current
      current = current.RightChildren
    }

    if parent.RightChildren == current {
      parent.RightChildren = current.LeftChildren
      current.LeftChildren = nil
    }
    return current
  }

  return current.RightChildren
}
