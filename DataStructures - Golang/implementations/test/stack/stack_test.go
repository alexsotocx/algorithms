package stack

import (
  "testing"
  "../../data/structures"
)

func TestStackPush(t *testing.T) {
  stack := structures.NewStack()
  stack.PushHead(1)
  stack.PushHead(2)
  stack.PushHead(3)

  expectedList(stack.Iterator(), []int{3, 2, 1}, t)
}

func TestStackDelete(t *testing.T) {
  stack := structures.NewStack()
  stack.PushHead(1)
  stack.PushHead(2)
  stack.PushHead(3)

  data, _ := stack.DeleteHead()

  if data != 3 {
    t.Errorf("Expected %d, got  %d\n", 1, data)
  }

  expectedList(stack.Iterator(), []int{2, 1}, t)
}

func expectedList(it structures.IteratorInterface, expected []int, t *testing.T) {
  for _, value := range expected {
    data, _ := it.Next()
    if value != data {
      t.Errorf("Expected %d, got  %d\n", value, data)
    }
  }

  if _, err := it.Next(); err == nil {
    t.Error("There should not be more elements")
  }
}

