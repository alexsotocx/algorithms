package trees

import "../interfaces"

type BinarySearchTree struct {
  BinaryTree
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

func (tree *BinarySearchTree) Find(data interfaces.Comparable) (bool, interfaces.Comparable) {
  current := tree.root
  for current != nil {
    valCom := current.Data.Compare(data)
    if valCom == 0 {
      return true, current.Data
    } else if valCom == 1 {
      current = current.RightChildren
    } else {
      current = current.LeftChildren
    }
  }
  return false, nil
}
