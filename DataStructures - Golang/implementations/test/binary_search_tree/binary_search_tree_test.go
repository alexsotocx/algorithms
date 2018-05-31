package binary_search_tree_test

import (
	"testing"
	"../../data/structures/trees"
  "../../data/structures/interfaces"
)

type Integer struct {
  value int
}

func (i Integer) Value() interface{} {
  return i.value
}

func (i Integer) Compare(a interfaces.Comparable) int8 {
  val := a.(Integer).value
  if i.value == val {
    return 0
  } else if  i.value < val {
    return 1
  }
  return -1
}

func TestInsert(t *testing.T) {
	tree := trees.BinarySearchTree{}
 tree.Insert(Integer{value: 4})
 tree.Insert(Integer{value: 2})
 tree.Insert(Integer{value: 5})
 tree.Insert(Integer{value: 1})
 tree.Insert(Integer{value: 3})

	if tree.Size() != 5 {
		t.Errorf("Expected %d, got  %d\n", 1, tree.Size())
	}

	expectInOrder(&tree, []interface{}{1, 2, 3, 4, 5}, t)
	expectPreOrder(&tree, []interface{}{4, 2, 1, 3, 5}, t)
	expectPostOrder(&tree, []interface{}{1, 3, 2, 5, 4}, t)
}

func TestFind(t *testing.T) {
	tree := trees.BinarySearchTree{}
  tree.Insert(Integer{value: 4})
  tree.Insert(Integer{value: 2})
  tree.Insert(Integer{value: 5})
  tree.Insert(Integer{value: 1})
  tree.Insert(Integer{value: 3})

	if found, c := tree.Find(Integer{value: 5}); !(found  && c.Value() == 5){
		t.Error("It should find the element 5")
	}

	if found, c := tree.Find(Integer{value: 6}); found && c != nil {
		t.Error("It should not find the element 6")
	}
}
//
//func TestDeleteRoot(t *testing.T) {
//  tree := trees.BinaryTree{}
//  tree.Insert(1)
//  tree.Insert(2)
//  tree.Insert(3)
//  tree.Insert(4)
//  tree.Insert(5)
//  tree.Insert(6)
//
//  if found, _ := tree.Find(1); !found {
//    t.Error("It should find the element 1")
//  }
//
//  tree.Delete(1)
//
//  if found, _ := tree.Find(1); found {
//    t.Error("It should not find the element 1")
//  }
//
//  expectPreOrder(&tree, []interface{}{6, 2, 4, 3, 5}, t)
//}
//
//func TestDeleteParentFromBranch(t *testing.T) {
//  tree := trees.BinaryTree{}
//  tree.Insert(1)
//  tree.Insert(2)
//  tree.Insert(3)
//  tree.Insert(4)
//  tree.Insert(5)
//  tree.Insert(6)
//
//  if found, _ := tree.Find(2); !found {
//    t.Error("It should find the element 2")
//  }
//
//  tree.Delete(2)
//
//  if found, _ := tree.Find(2); found {
//    t.Error("It should not find the element 2")
//  }
//
//  expectPreOrder(&tree, []interface{}{1, 6, 4, 3, 5}, t)
//}
//
//func TestDeleteLeft(t *testing.T) {
//  tree := trees.BinaryTree{}
//  tree.Insert(1)
//  tree.Insert(2)
//  tree.Insert(3)
//  tree.Insert(4)
//  tree.Insert(5)
//  tree.Insert(6)
//
//  if found, _ := tree.Find(3); !found {
//    t.Error("It should find the element 3")
//  }
//
//  tree.Delete(3)
//
//  if found, _ := tree.Find(3); found {
//    t.Error("It should not find the element 3")
//  }
//
//  expectPreOrder(&tree, []interface{}{1, 2, 4, 6, 5}, t)
//}
//
//
func expectInOrder(tree *trees.BinarySearchTree, expected []interface{}, t *testing.T) {
  i := 0
  tree.InOrder(func(data interfaces.Comparable) {
    if expected[i] != data.Value() {
      t.Errorf("Expected %d, got  %d\n", expected[i], data)
    }
    i++
  })
}

func expectPreOrder(tree *trees.BinarySearchTree, expected []interface{}, t *testing.T) {
  i := 0
  tree.PreOrder(func(data interfaces.Comparable) {
    if expected[i] != data.Value() {
      t.Errorf("Expected %d, got  %d\n", expected[i], data.Value())
    }
    i++
  })
}

func expectPostOrder(tree *trees.BinarySearchTree, expected []interface{}, t *testing.T) {
  i := 0
  tree.PosOrder(func(data interfaces.Comparable) {
    if expected[i] != data.Value() {
      t.Errorf("Expected %d, got  %d\n", expected[i], data.Value())
    }
    i++
  })
}
