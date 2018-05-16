package linked_list

type Queue interface {
  PushBack(data interface{}) (bool, error)
  DeleteHead() (interface{}, error)
  First() interface{}
  Iterator() IteratorInterface
}

func NewQueue() Queue {
  return &DoubleLinkedList{}
}

