package trees


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

func (tree *BinaryTree) Insert(data interface{})  {
  if tree.IsEmpty() {
    tree.root = newNode(data)
  } else {
    node := newNode(data)
    parentNode := tree.root
    for i := uint(1); i <= tree.size; i <<= 1 {
      if (tree.size & i) != 0 {
        if parentNode.LeftChildren == nil {
          parentNode.LeftChildren = node
          break
        }
        parentNode = parentNode.LeftChildren
      } else {
        if parentNode.RightChildren == nil {
          parentNode.RightChildren = node
          break
        }
        parentNode = parentNode.RightChildren
      }
    }
  }
  tree.size++
}

func (tree BinaryTree) InOrder(eachFunction func(interface{})) {
  tree.inOrder(tree.root, eachFunction)
}

func (tree BinaryTree) inOrder(current *node, eachFunction func(interface{})) {
  if current != nil {
    tree.inOrder(current.LeftChildren, eachFunction)
    eachFunction(current.Data)
    tree.inOrder(current.RightChildren, eachFunction)
  }
}

func (tree BinaryTree) PreOrder(eachFunction func(interface{})) {
  tree.preOrder(tree.root, eachFunction)
}

func (tree BinaryTree) preOrder(current *node, eachFunction func(interface{})) {
  if current != nil {
    eachFunction(current.Data)
    tree.preOrder(current.LeftChildren, eachFunction)
    tree.preOrder(current.RightChildren, eachFunction)
  }
}

func (tree BinaryTree) PosOrder(eachFunction func(interface{})) {
  tree.posOrder(tree.root, eachFunction)
}

func (tree BinaryTree) posOrder(current *node, eachFunction func(interface{})) {
  if current != nil {
    tree.posOrder(current.LeftChildren, eachFunction)
    tree.posOrder(current.RightChildren, eachFunction)
    eachFunction(current.Data)
  }
}

func (tree BinaryTree) IsEmpty() bool {
  return tree.size == 0
}

func (tree BinaryTree) Size() uint {
  return tree.size
}





