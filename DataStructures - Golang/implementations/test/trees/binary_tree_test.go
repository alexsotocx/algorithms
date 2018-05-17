package trees_test

import(
  "testing"
  "../../data/structures/trees"
)

func TestInsert(t *testing.T) {
  tree := trees.BinaryTree{}
  tree.Insert(1)
  tree.Insert(2)
  tree.Insert(3)
  tree.Insert(4)
  tree.Insert(5)

  if tree.Size() != 5 {
    t.Errorf("Expected %d, got  %d\n", 1, tree.Size())
  }

  expectInOrder(&tree, []interface{}{4, 2 , 1, 3, 5}, t)
  expectPreOrder(&tree, []interface{}{1, 2 , 4, 3, 5}, t)
  expectPostOrder(&tree, []interface{}{4, 2 , 5, 3, 1}, t)
}

func expectInOrder(tree *trees.BinaryTree, expected []interface{}, t *testing.T){
  i := 0
  tree.InOrder(func(data interface{}) {
    if expected[i] != data {
      t.Errorf("Expected %d, got  %d\n", expected[i] , data)
    }
    i++
  });
}

func expectPreOrder(tree *trees.BinaryTree, expected []interface{}, t *testing.T){
  i := 0
  tree.PreOrder(func(data interface{}) {
    if expected[i] != data {
      t.Errorf("Expected %d, got  %d\n", expected[i] , data)
    }
    i++
  });
}

func expectPostOrder(tree *trees.BinaryTree, expected []interface{}, t *testing.T){
  i := 0
  tree.PosOrder(func(data interface{}) {
    if expected[i] != data {
      t.Errorf("Expected %d, got  %d\n", expected[i] , data)
    }
    i++
  });
}

