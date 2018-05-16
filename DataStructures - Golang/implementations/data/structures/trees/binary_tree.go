package trees

import "errors"

type node struct {
  LeftChildren *node
  RightChildren *node
  Data interface{}
}

func newNode(data interface{}) *node {
  node := new(node)
  node.Data = data
  return node
}

type BinaryTree struct {
  root *node
  size uint
}

func (tree *BinaryTree) insert(data interface{})  {
  if tree.IsEmpty() {
    tree.root = newNode(data)
  } else {
    node := newNode(data)
    parentNode := tree.root
    for i := uint(1); i <= tree.size; i *= 2 {
      if (tree.size & i) != 1 {
        if parentNode.LeftChildren == nil {
          parentNode.LeftChildren = node
          return
        }
        parentNode = parentNode.LeftChildren
      } else {
        if parentNode.RightChildren == nil {
          parentNode.RightChildren = node
          return
        }
        parentNode = parentNode.RightChildren
      }
    }
  }
}

func (tree BinaryTree) IsEmpty() bool {
  return tree.size == 0
}






