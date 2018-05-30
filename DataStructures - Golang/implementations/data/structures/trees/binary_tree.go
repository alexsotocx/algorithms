package trees

import "../interfaces"

type node struct {
	LeftChildren  *node
	RightChildren *node
	Data          interfaces.Comparable
}

func newNode(data interfaces.Comparable) *node {
	node := new(node)
	node.Data = data
	return node
}

type BinaryTree struct {
	root *node
	size uint
}

func (tree *BinaryTree) Insert(data interfaces.Comparable) {
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

func (tree BinaryTree) Find(data interfaces.Comparable) (bool, interfaces.Comparable)  {
	f, _, c := tree.find(data, nil, tree.root)
	if f { return f, c.Data }
	return false, nil
}

func (tree BinaryTree) find(data interfaces.Comparable, parent *node, current *node,) (bool, *node, *node)  {
  if current != nil {
    if current.Data.Compare(data)  == 0 {
      return true, parent, current
    }
    if f, p, c := tree.find(data, current, current.LeftChildren); f {
      return f, p, c
    }
    if f, p, c := tree.find(data, current, current.RightChildren); f {
      return f, p, c
    }
  }

  return false, nil, nil
}

func (tree *BinaryTree) Delete(data interfaces.Comparable) (bool, interfaces.Comparable) {
  found, _, toDelete := tree.find(data, nil, tree.root)
  if found {
    replacementParent, replacement := tree.findReplacement()

    if replacementParent.LeftChildren == replacement {
      replacementParent.LeftChildren = nil
    } else {
      replacementParent.RightChildren = nil
    }

    temp := toDelete.Data
    toDelete.Data = replacement.Data

    tree.size -= 1
    return true, temp

  }

  return false, nil
}

func (tree BinaryTree) findReplacement() (*node, *node) {
  var parent *node
  selected := tree.root
  for i := uint(1); i < tree.size; i <<= 1 {
    if ((tree.size - 1) & i) != 0 {
      if selected.LeftChildren != nil {
        parent = selected
        selected = selected.LeftChildren
      } else if selected.RightChildren == nil {
        return parent, selected
      }
    } else {
      if selected.RightChildren != nil {
        parent = selected
        selected = selected.RightChildren
      } else if selected.LeftChildren == nil {
        return parent, selected
      }
    }
  }
  return parent, selected
}

func (tree BinaryTree) InOrder(eachFunction func(interfaces.Comparable)) {
	tree.inOrder(tree.root, eachFunction)
}

func (tree BinaryTree) inOrder(current *node, eachFunction func(interfaces.Comparable)) {
	if current != nil {
		tree.inOrder(current.LeftChildren, eachFunction)
		eachFunction(current.Data)
		tree.inOrder(current.RightChildren, eachFunction)
	}
}

func (tree BinaryTree) PreOrder(eachFunction func(interfaces.Comparable)) {
	tree.preOrder(tree.root, eachFunction)
}

func (tree BinaryTree) preOrder(current *node, eachFunction func(interfaces.Comparable)) {
	if current != nil {
		eachFunction(current.Data)
		tree.preOrder(current.LeftChildren, eachFunction)
		tree.preOrder(current.RightChildren, eachFunction)
	}
}

func (tree BinaryTree) PosOrder(eachFunction func(interfaces.Comparable)) {
	tree.posOrder(tree.root, eachFunction)
}

func (tree BinaryTree) posOrder(current *node, eachFunction func(interfaces.Comparable)) {
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
