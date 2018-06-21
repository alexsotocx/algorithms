package linked_list_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/linked_list"
)

func TestPushHead(t *testing.T) {
	list := linked_list.DoubleLinkedList{}
	list.PushHead(3)
	list.PushHead(4)
	list.PushHead(5)

	if list.Size() != 3 {
		t.Error("Size is expected to be 3")
	}

	expectList(&list, []int{5, 4, 3}, t)
}

func TestPushBack(t *testing.T) {
	list := linked_list.DoubleLinkedList{}
	list.PushBack(3)
	list.PushBack(4)
	list.PushBack(5)

	if list.Size() != 3 {
		t.Error("Size is expected to be 3")
	}

	expectList(&list, []int{3, 4, 5}, t)
}

func TestDeleteTail(t *testing.T) {
	list := linked_list.DoubleLinkedList{}
	list.PushBack(3)
	list.PushBack(4)
	list.PushBack(5)

	list.DeleteTail()

	if list.Size() != 2 {
		t.Error("Size is expected to be 2")
	}

	expectList(&list, []int{3, 4}, t)
}

func TestDeleteHead(t *testing.T) {
	list := linked_list.DoubleLinkedList{}
	list.PushBack(3)
	list.PushBack(4)
	list.PushBack(5)

	list.DeleteHead()

	if list.Size() != 2 {
		t.Error("Size is expected to be 2")
	}

	expectList(&list, []int{4, 5}, t)
}

func TestDeleteHeadWithEmptyList(t *testing.T) {
	list := linked_list.DoubleLinkedList{}
	_, err := list.DeleteHead()

	if err == nil {
		t.Error("Error Expected")
	}
}

func TestDeleteTailWithEmptyList(t *testing.T) {
	list := linked_list.DoubleLinkedList{}
	_, err := list.DeleteTail()

	if err == nil {
		t.Error("Error Expected")
	}
}

func expectList(currentList *linked_list.DoubleLinkedList, expected []int, t *testing.T) {
	it := currentList.Iterator()
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
