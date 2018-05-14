package test

import (
  "testing"
  "../data/structures/doublelinkedlist"
)

func TestPushHead(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  list.PushHead(3)
  list.PushHead(4)
  list.PushHead(5)

  output := []int{5, 4, 3}
  it := list.First()
  for _, value := range output {
    if value != it.Data {
      t.Errorf("Expected %d, got  %d\n", value, it.Data)
    }
    it = it.Next
  }
}


func TestPushBack(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  list.PushBack(3)
  list.PushBack(4)
  list.PushBack(5)

  output := []int{3, 4, 5}
  it := list.First()
  for _, value := range output {
    if value != it.Data {
      t.Errorf("Expected %d, got  %d\n", value, it.Data)
    }
    it = it.Next
  }
}
