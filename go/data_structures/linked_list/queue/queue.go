package queue

import . "github.com/alexsotocx/algorithms/go/data_structures/linked_list"

type Queue interface {
	PushBack(data interface{}) (bool, error)
	DeleteHead() (interface{}, error)
	First() interface{}
	Iterator() IteratorInterface
	IsEmpty() bool
}

func New() Queue {
	return &DoubleLinkedList{}
}
