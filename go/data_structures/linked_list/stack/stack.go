package stack

import . "github.com/alexsotocx/algorithms/go/data_structures/linked_list"

type Stack interface {
	PushHead(data interface{}) (bool, error)
	DeleteHead() (interface{}, error)
	First() interface{}
	Iterator() IteratorInterface
}

func NewStack() Stack {
	return &DoubleLinkedList{}
}
