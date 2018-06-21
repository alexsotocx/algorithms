package stack_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/linked_list"
	"github.com/alexsotocx/algorithms/go/data_structures/linked_list/stack"
)

func TestStackPush(t *testing.T) {
	s := stack.NewStack()
	s.PushHead(1)
	s.PushHead(2)
	s.PushHead(3)

	expectedList(s.Iterator(), []int{3, 2, 1}, t)
}

func TestStackDelete(t *testing.T) {
	s := stack.NewStack()
	s.PushHead(1)
	s.PushHead(2)
	s.PushHead(3)

	data, _ := s.DeleteHead()

	if data != 3 {
		t.Errorf("Expected %d, got  %d\n", 1, data)
	}

	expectedList(s.Iterator(), []int{2, 1}, t)
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
