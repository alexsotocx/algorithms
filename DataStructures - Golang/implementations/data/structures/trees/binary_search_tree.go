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
     if data.Compare(parent.Data) == 1  {
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
