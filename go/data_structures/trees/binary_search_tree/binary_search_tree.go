package binary_search_tree

import (
	"github.com/alexsotocx/algorithms/go/data_structures/interfaces"
	"github.com/alexsotocx/algorithms/go/data_structures/trees/binary_tree"
	"github.com/alexsotocx/algorithms/go/data_structures/trees/node"
)

type BinarySearchTree struct {
	binary_tree.BinaryTree
}

func (tree *BinarySearchTree) Insert(data interfaces.Comparable) {
	tree.Size++
	if tree.Root == nil {
		tree.Root = node.New(data)
	} else {
		parent := tree.Root
		for {
			if parent.Data.Compare(data) == 1 {
				if parent.RightChildren == nil {
					parent.RightChildren = node.New(data)
					break
				}
				parent = parent.RightChildren
			} else {
				if parent.LeftChildren == nil {
					parent.LeftChildren = node.New(data)
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

func (tree BinarySearchTree) find(data interfaces.Comparable) (*node.Node, *node.Node) {
	current := tree.Root
	var parent *node.Node
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
		tree.Size--
		if toDelete.RightChildren == nil && toDelete.LeftChildren != nil {
			if toDelete == tree.Root {
				tree.Root = nil
				return true, data
			}
			if parent.LeftChildren == toDelete {
				parent.LeftChildren = nil
			} else {
				parent.RightChildren = nil
			}
		} else {
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

func (tree BinarySearchTree) findAndReplace(current *node.Node) *node.Node {
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
