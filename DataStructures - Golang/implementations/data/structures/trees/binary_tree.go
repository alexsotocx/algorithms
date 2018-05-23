package trees

type node struct {
	LeftChildren  *node
	RightChildren *node
	Parent        *node
	Data          interface{}
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

func (tree *BinaryTree) Insert(data interface{}) {
	if tree.IsEmpty() {
		tree.root = newNode(data)
	} else {
		node := newNode(data)
		parentNode := tree.root
		for i := uint(1); i <= tree.size; i <<= 1 {
			if (tree.size & i) != 0 {
				if parentNode.LeftChildren == nil {
				  node.Parent = parentNode.LeftChildren
					parentNode.LeftChildren = node
					break
				}
				parentNode = parentNode.LeftChildren
			} else {
				if parentNode.RightChildren == nil {
          node.Parent = parentNode.RightChildren
					parentNode.RightChildren = node
					break
				}
				parentNode = parentNode.RightChildren
			}
		}
	}
	tree.size++
}

func (tree BinaryTree) Find(data interface{}) (bool, *node)  {
	return tree.find(data, tree.root)
}

func (tree BinaryTree) find(data interface{}, current *node) (bool, *node)  {
  if current != nil {
    if current.Data == data {
      return true, current
    }
    if f, n := tree.find(data, current.LeftChildren); f {
      return f, n
    }
    if f, n := tree.find(data, current.RightChildren); f {
      return f, n
    }
  }

  return false, nil
}

func (tree *BinaryTree) Delete(data interface{}) (bool, interface{}) {
  found, toDelete := tree.Find(data)
  if found {
    tree.size -= 1
    replacement := tree.findReplacement()
    if replacement.Parent.LeftChildren == replacement {
      replacement.Parent.LeftChildren = nil
    } else {
      replacement.Parent.RightChildren = nil
    }

    if replacement == toDelete {
      replacement.Parent = nil
      return true, toDelete.Data
    }

    if toDelete == toDelete.Parent.LeftChildren {
      toDelete.Parent.LeftChildren = replacement
    } else {
      toDelete.Parent.RightChildren = replacement
    }

    replacement.Parent = toDelete.Parent
    if toDelete.RightChildren != nil {
      toDelete.RightChildren.Parent = replacement
      replacement.RightChildren = toDelete.RightChildren
    }
    if toDelete.LeftChildren != nil {
      toDelete.LeftChildren.Parent = replacement
      replacement.LeftChildren = toDelete.LeftChildren
    }
    if toDelete == tree.root {
      tree.root = replacement
    }
    return true, toDelete.Data

  }

  return false, nil
}

func (tree BinaryTree) findReplacement() *node {
  selected := tree.root
  for i := uint(1); i <= tree.size; i <<= 1 {
    if selected.LeftChildren == nil && selected.RightChildren == nil {
      return selected
    }
    if (tree.size & i) != 0 {
      if selected.LeftChildren != nil {
        selected = selected.LeftChildren
      }
    } else {
      if selected.RightChildren != nil {
        selected = selected.RightChildren
      }
    }
  }
  return selected
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
