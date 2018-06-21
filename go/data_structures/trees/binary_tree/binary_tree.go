package binary_tree

import (
	"github.com/alexsotocx/algorithms/go/data_structures/interfaces"
	"github.com/alexsotocx/algorithms/go/data_structures/trees/node"
)

type BinaryTree struct {
	Root *node.Node
	Size uint
}

func (tree *BinaryTree) Insert(data interfaces.Comparable) {
	if tree.IsEmpty() {
		tree.Root = node.New(data)
	} else {
		node := node.New(data)
		parentNode := tree.Root
		for i := uint(1); i <= tree.Size; i <<= 1 {
			if (tree.Size & i) != 0 {
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
	tree.Size++
}

func (tree BinaryTree) Find(data interfaces.Comparable) (bool, interfaces.Comparable) {
	f, _, c := tree.find(data, nil, tree.Root)
	if f {
		return f, c.Data
	}
	return false, nil
}

func (tree BinaryTree) find(data interfaces.Comparable, parent *node.Node, current *node.Node) (bool, *node.Node, *node.Node) {
	if current != nil {
		if current.Data.Compare(data) == 0 {
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
	found, _, toDelete := tree.find(data, nil, tree.Root)
	if found {
		replacementParent, replacement := tree.findReplacement()

		if replacementParent.LeftChildren == replacement {
			replacementParent.LeftChildren = nil
		} else {
			replacementParent.RightChildren = nil
		}

		temp := toDelete.Data
		toDelete.Data = replacement.Data

		tree.Size -= 1
		return true, temp

	}

	return false, nil
}

func (tree BinaryTree) findReplacement() (*node.Node, *node.Node) {
	var parent *node.Node
	selected := tree.Root
	for i := uint(1); i < tree.Size; i <<= 1 {
		if ((tree.Size - 1) & i) != 0 {
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
	tree.inOrder(tree.Root, eachFunction)
}

func (tree BinaryTree) inOrder(current *node.Node, eachFunction func(interfaces.Comparable)) {
	if current != nil {
		tree.inOrder(current.LeftChildren, eachFunction)
		eachFunction(current.Data)
		tree.inOrder(current.RightChildren, eachFunction)
	}
}

func (tree BinaryTree) PreOrder(eachFunction func(interfaces.Comparable)) {
	tree.preOrder(tree.Root, eachFunction)
}

func (tree BinaryTree) preOrder(current *node.Node, eachFunction func(interfaces.Comparable)) {
	if current != nil {
		eachFunction(current.Data)
		tree.preOrder(current.LeftChildren, eachFunction)
		tree.preOrder(current.RightChildren, eachFunction)
	}
}

func (tree BinaryTree) PosOrder(eachFunction func(interfaces.Comparable)) {
	tree.posOrder(tree.Root, eachFunction)
}

func (tree BinaryTree) posOrder(current *node.Node, eachFunction func(interfaces.Comparable)) {
	if current != nil {
		tree.posOrder(current.LeftChildren, eachFunction)
		tree.posOrder(current.RightChildren, eachFunction)
		eachFunction(current.Data)
	}
}

func (tree BinaryTree) IsEmpty() bool {
	return tree.Size == 0
}
