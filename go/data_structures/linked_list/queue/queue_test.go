package queue_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/linked_list"
	"github.com/alexsotocx/algorithms/go/data_structures/linked_list/queue"
)

func TestQueuePushBack(t *testing.T) {
	q := queue.New()
	q.PushBack(1)
	q.PushBack(2)
	q.PushBack(3)

	expectedList(q.Iterator(), []int{1, 2, 3}, t)
}

func TestQueueDelete(t *testing.T) {
	q := queue.New()
	q.PushBack(1)
	q.PushBack(2)
	q.PushBack(3)

	data, _ := q.DeleteHead()

	if data != 1 {
		t.Errorf("Expected %d, got  %d\n", 1, data)
	}

	expectedList(q.Iterator(), []int{2, 3}, t)
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
