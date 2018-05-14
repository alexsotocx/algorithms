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

  expectList(&list, []int{5, 4, 3}, t)
}


func TestPushBack(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  list.PushBack(3)
  list.PushBack(4)
  list.PushBack(5)

  expectList(&list, []int{3, 4, 5}, t)
}

func TestDeleteTail(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  list.PushBack(3)
  list.PushBack(4)
  list.PushBack(5)

  list.DeleteTail()

  expectList(&list, []int{3, 4}, t)
}

func TestDeleteHead(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  list.PushBack(3)
  list.PushBack(4)
  list.PushBack(5)

  list.DeleteHead()


  expectList(&list, []int{4, 5}, t)
}

func TestDeleteHeadWithEmptyList(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  _, err := list.DeleteHead()

  if err == nil {
    t.Error("Error Expected")
  }
}

func TestDeleteTailWithEmptyList(t *testing.T) {
  list := doublelinkedlist.DoubleLinkedList{}
  _, err := list.DeleteTail()

  if err == nil {
    t.Error("Error Expected")
  }
}


func expectList(currentList *doublelinkedlist.DoubleLinkedList, expected []int, t *testing.T) {
  it := currentList.First()
  for _, value := range expected {
    if value != it.Data {
      t.Errorf("Expected %d, got  %d\n", value, it.Data)
    }
    it = it.Next
  }

  if it != nil {
    t.Errorf("Expected iterator to be at the end of the list")
  }
}
