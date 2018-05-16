package queue

import (
  "testing"
  "../../data/structures/linked_list"
)

func TestQueuePushBack(t *testing.T) {
  queue := linked_list.NewQueue()
  queue.PushBack(1)
  queue.PushBack(2)
  queue.PushBack(3)

  expectedList(queue.Iterator(), []int{1, 2, 3}, t)
}

func TestQueueDelete(t *testing.T) {
  queue := linked_list.NewQueue()
  queue.PushBack(1)
  queue.PushBack(2)
  queue.PushBack(3)

  data, _ := queue.DeleteHead()

  if data != 1 {
    t.Errorf("Expected %d, got  %d\n", 1, data)
  }

  expectedList(queue.Iterator(), []int{2, 3}, t)
}

func expectedList(it linked_list.IteratorInterface, expected []int, t *testing.T) {
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
